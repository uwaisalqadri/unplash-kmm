//
//  MainViewModel.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Combine
import KMPNativeCoroutinesCombine
import Shared

class MainViewModel: ObservableObject {

  private let photoUseCase: PhotoUseCase
  private var cancellables = Set<AnyCancellable>()

  init(photoUseCase: PhotoUseCase) {
    self.photoUseCase = photoUseCase
  }

  func getPhotos() {
    createPublisher(for: photoUseCase.getPhotosNative(page: 1, perPage: 10, orderBy: ""))
      .receive(on: DispatchQueue.main)
      .sink { completion in
        switch completion {
        case .finished: ()
        case .failure(let error):
          print("ERROR HERE \(error)")
        }
      } receiveValue: { value in
        print("SUCCESS THERE \(value)")
      }.store(in: &cancellables)
  }
}
