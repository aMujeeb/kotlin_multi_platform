import SwiftUI
import shared

struct ContentView: View {
    
    @State private var shouldOpenAbout = false
    
    var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())
        
        NavigationStack {
            ArticlesScreen(viewModel: .init())
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            DeviceDetailScreen()
                        }
                    }
                }
        }.refreshable {
            articleScreen.viewModel.articleViewModel.getArticles(forceToRefresh: true)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
