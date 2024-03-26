import SwiftUI
import shared

@main
struct iOSApp: App {
    //Initiating the Koin lib in IOS
    init(){
        KoinInitializerKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
