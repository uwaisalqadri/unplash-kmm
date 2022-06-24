//
//  PhotoView.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct PhotoView: View {

  @ObservedObject var viewModel: PhotoViewModel

	var body: some View {
    NavigationView {
      ScrollView {
        VStack {
          if case .success(let data) = viewModel.photos {
            ForEach(data, id: \.id) { photo in
              PhotoRow(photo: photo)
            }
          } else if case .error(let error) = viewModel.photos {
            ForEach(error.apiError?.errors ?? [], id: \.self) { error in
              Text(error)
            }
          }
        }
      }.navigationBarTitle("Photo")
    }.onAppear {
      viewModel.getPhotos()
    }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
    PhotoView(viewModel: Injector.injectViewModel())
	}
}
