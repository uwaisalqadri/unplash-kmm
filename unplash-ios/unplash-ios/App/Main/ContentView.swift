//
//  ContentView.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct ContentView: View {

  @ObservedObject var viewModel: MainViewModel

	var body: some View {
		Text("HALO")
      .onAppear {
        viewModel.getPhotos()
      }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
    ContentView(viewModel: Injector.injectViewModel())
	}
}
