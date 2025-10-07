This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

### Android studio view

<img width="1919" height="1012" alt="Screenshot 2025-10-07 192844" src="https://github.com/user-attachments/assets/274565b4-51a9-49a7-95f8-8d195eb0407f" />
<img width="472" height="768" alt="Screenshot 2025-10-07 193126" src="https://github.com/user-attachments/assets/1e7054c4-7542-4ec7-aeae-6c3d6f78cbba" />
<img width="512" height="920" alt="Screenshot 2025-10-07 193054" src="https://github.com/user-attachments/assets/9130bd79-4825-428f-8114-8ce3402b2a46" />
<img width="1919" height="1011" alt="Screenshot 2025-10-07 193003" src="https://github.com/user-attachments/assets/866e101c-4b77-4225-bc24-f91a14cf7d82" />
<img width="1916" height="1008" alt="Screenshot 2025-10-07 192927" src="https://github.com/user-attachments/assets/36661bf3-fbea-40d3-bf98-6e544e56f8f5" />
