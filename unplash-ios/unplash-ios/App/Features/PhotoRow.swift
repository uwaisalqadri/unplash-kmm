//
//  PhotoRow.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SDWebImageSwiftUI
import Shared

struct PhotoRow: View {

  let photo: Photo

  var body: some View {
    WebImage(url: URL(string: photo.urls.small))
      .resizable()
      .scaledToFill()
      .frame(maxWidth: .infinity, maxHeight: 200)
      .cornerRadius(10)
      .padding(.horizontal, 16)
      .padding(.vertical, 6)
  }
}
