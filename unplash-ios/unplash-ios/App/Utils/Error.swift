//
//  Error.swift
//  unplash-ios
//
//  Created by Uwais Alqadri on 6/24/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Shared

extension Error {
  var apiError: ApiError? {
    (self as NSError).userInfo["KotlinException"] as? ApiError
  }
}
