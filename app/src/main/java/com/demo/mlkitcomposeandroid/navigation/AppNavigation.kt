package com.demo.mlkitcomposeandroid.navigation

import com.demo.mlkitcomposeandroid.persentation.screens.barcode_scanning.BarcodeScanningScreen
import com.demo.mlkitcomposeandroid.persentation.screens.face_mesh_detection.FaceMeshDetectionScreen
import com.demo.mlkitcomposeandroid.persentation.screens.home.HomeScreen
import com.demo.mlkitcomposeandroid.persentation.screens.image_labeling.ImageLabelingScreen
import com.demo.mlkitcomposeandroid.persentation.screens.object_detection.ObjectDetectionScreen
import com.demo.mlkitcomposeandroid.persentation.screens.text_recognition.TextRecognitionScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost


internal sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object FaceMeshDetection : Screen("face_mesh_detection")
    data object TextRecognition : Screen("text_recognition")
    data object ObjectDetection : Screen("object_detection")
    data object BarcodeScanning : Screen("barcode_scanning")
    data object ImageLabeling : Screen("image_labeling")

}

@OptIn(androidx.compose.animation.ExperimentalAnimationApi::class)
@androidx.compose.runtime.Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()
   AnimatedNavHost(
        navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.TextRecognition.route) {
            TextRecognitionScreen(navController)
        }
        composable(route = Screen.ObjectDetection.route) {
            ObjectDetectionScreen(navController)
        }
        composable(route = Screen.FaceMeshDetection.route) {
            FaceMeshDetectionScreen(navController)
        }
        composable(route = Screen.BarcodeScanning.route) {
            BarcodeScanningScreen(navController)
        }
        composable(route = Screen.ImageLabeling.route) {
            ImageLabelingScreen(navController)
        }
    }
}