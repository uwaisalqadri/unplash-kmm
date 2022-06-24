//
//  iOSApp.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared
import netfox

@main
struct iOSApp: App {

  init() {
    CoreModuleKt.doInitKoin()
    NFX.sharedInstance().start()
  }

	var body: some Scene {
		WindowGroup {
      PhotoView(viewModel: Injector.injectViewModel())
		}
	}
}
