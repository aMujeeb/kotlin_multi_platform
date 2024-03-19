//
//  DeviceDetails.swift
//  MultiTesterIos
//
//  Created by Ahamed Mujeeb on 18/3/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DeviceDetailsListView: View {
    
    private struct RowItem: Hashable {
        let title : String
        let subTitle : String
    }
    
    private let items: [RowItem] = {
        let deviceDetails = PhoneDetails()
        deviceDetails.logInformation()
        
        var result: [RowItem] = [
            .init(title: "Operating System", subTitle:"\(deviceDetails.osName) \(deviceDetails.osVersion)"),
            .init(title: "Device", subTitle:deviceDetails.deviceModel),
            .init(title: "Density", subTitle:"@\(deviceDetails.density)x")
        ]
        
        return result
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading){
                    Text(item.title).font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subTitle).font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    DeviceDetailsListView()
}
