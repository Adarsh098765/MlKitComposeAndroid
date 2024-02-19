package com.demo.mlkitcomposeandroid.persentation.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.mlkitcomposeandroid.persentation.common.components.ImageCard
import com.demo.mlkitcomposeandroid.R
import com.demo.mlkitcomposeandroid.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                title = { Text(text = stringResource(id = R.string.app_name)) })
        },
        contentColor = MaterialTheme.colorScheme.primary,
        content = {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(initialAlpha = 0.3f),
                exit = fadeOut()
            ) {
                LazyVerticalGrid(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                    columns = GridCells.Adaptive(180.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    contentPadding = it
                ) {
                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
                            exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 })
                        ) {
                            ImageCard(
                                title = stringResource(id = R.string.barcode_detection_title),
                                description = stringResource(id = R.string.barcode_detection_description),
                                imageUrl = stringResource(id = R.string.barcode_detection_url),
                                onCardClick = { navController.navigate(Screen.BarcodeScanning.route) }
                            )
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
                            exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 })
                        ) {
                            ImageCard(
                                title = stringResource(id = R.string.face_mesh_detection_title),
                                description = stringResource(id = R.string.face_mesh_detection_description),
                                imageUrl = stringResource(id = R.string.face_mesh_detection_url),
                                onCardClick = { navController.navigate(Screen.FaceMeshDetection.route) }
                            )
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
                            exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 })
                        ) {
                            ImageCard(
                                title = stringResource(id = R.string.text_recognition_title),
                                description = stringResource(id = R.string.text_recognition_description),
                                imageUrl = stringResource(id = R.string.text_recognition_url),
                                onCardClick = { navController.navigate(Screen.TextRecognition.route) }
                            )
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
                            exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 })
                        ) {
                            ImageCard(
                                title = stringResource(id = R.string.image_labeling_detection_title),
                                description = stringResource(id = R.string.image_labeling_detection_description),
                                imageUrl = stringResource(id = R.string.image_labeling_detection_url),
                                onCardClick = { navController.navigate(Screen.ImageLabeling.route) }
                            )
                        }
                    }

                    item {
                        AnimatedVisibility(
                            visible = true,
                            enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight / 2 }),
                            exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight / 2 })
                        ) {
                            ImageCard(
                                title = stringResource(id = R.string.object_detection_title),
                                description = stringResource(id = R.string.object_detection_description),
                                imageUrl = stringResource(id = R.string.object_detection_url),
                                onCardClick = { navController.navigate(Screen.ObjectDetection.route) }
                            )
                        }
                    }
                }
            }
        }

    )
}