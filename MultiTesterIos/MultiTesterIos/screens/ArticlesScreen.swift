//
//  ArticlesScreen.swift
//  MultiTesterIos
//
//  Created by Ahamed Mujeeb on 21/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper : ObservableObject {
        let articleViewModel : ArticleViewModel
        
        init() {
            articleViewModel = ArticlesInjector().articleVideModel
            articleState = articleViewModel.mArticleState.value
        }
        
        @Published var articleState : ArticleState
        
        func startObserving() {
            //Converting kotlin stateflow into IOS publisher
            Task {
                for await articlesS in articleViewModel.mArticleState {
                    self.articleState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar()
            
            //if viewModel.articleState.loading {
                //Loader()
            //}
            
            if let error = viewModel.articleState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.articleState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10){
                        ForEach(viewModel.articleState.articles, id:\.self) { article in
                            ArticleItemView(mArticle: article)
                        }
                    }
                }
            }
        }.onAppear {
            self.viewModel.startObserving() //calling above defined Observer
        }
    }
}

struct AppBar : View {
    
    var body: some View {
        Text("Articles").font(.largeTitle).fontWeight(.bold)
    }
}


struct ArticleItemView : View {
    var mArticle : Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: mArticle.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!.resizable().aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Loader Error")
                } else {
                    ProgressView()
                }
            }
            
            Text(mArticle.title).font(.title).fontWeight(.bold)
            Text(mArticle.desc).font(.caption).fontWeight(.regular)
            Text(mArticle.date).frame(maxWidth:.infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

//No need a progress indicator since pull to refresh view
/*struct Loader : View {
    var body: some View {
        ProgressView()
    }
} */

struct ErrorMessage : View {
    var message : String
    
    var body: some View {
        Text(message).font(.title)
    }
}

