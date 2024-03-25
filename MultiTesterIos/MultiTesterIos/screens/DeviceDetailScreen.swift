//
//  DeviceDetailScreen.swift
//  MultiTesterIos
//
//  Created by Ahamed Mujeeb on 18/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct DeviceDetailScreen: View {
    
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            DeviceDetailsListView()
            .navigationTitle("About Device")
            .toolbar(content: {
                ToolbarItem(placement: .primaryAction) {
                    Button {
                        dismiss()
                    } label: {
                        Text("Done").bold()
                    }
                }
            })
        }
    }
}

#Preview {
    DeviceDetailScreen()
}
