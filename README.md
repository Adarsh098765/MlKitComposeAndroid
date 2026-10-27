# ML Kit Vision Lab: Jetpack Compose + CameraX

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-7F52FF?logo=kotlin&logoColor=white) ![Jetpack](https://img.shields.io/badge/Jetpack-Compose-4285F4?logo=jetpackcompose&logoColor=white) ![ML Kit](https://img.shields.io/badge/ML%20Kit-on--device-FF6F00?logo=google&logoColor=white) ![CameraX](https://img.shields.io/badge/CameraX-1.3-3DDC84?logo=android&logoColor=white) ![Android](https://img.shields.io/badge/Android-minSdk%2026-3DDC84?logo=android&logoColor=white)

A showcase app that runs **six Google ML Kit vision models on-device, in real time**, on a live CameraX feed. Detection results are drawn as **Jetpack Compose Canvas overlays** that stay aligned with the camera preview.

## Features

| Screen | ML Kit API | What it does |
|---|---|---|
| Face Detection | `face-detection` | Bounding boxes around faces in the frame |
| Face Mesh | `face-mesh-detection` (beta) | 468-point 3D face mesh drawn over the face |
| Object Detection | `object-detection` | Detects and tracks prominent objects |
| Barcode Scanning | `barcode-scanning` | Reads QR codes and 1D/2D barcodes |
| Text Recognition | `text-recognition` | On-device OCR of Latin-script text |
| Image Labeling | `image-labeling` | Classifies what's in the scene with confidence scores |

## How it works

```
CameraX Preview ──► ImageAnalysis.Analyzer (one per model)
                       │  InputImage.fromMediaImage(...)
                       ▼
                ML Kit detector (on-device, no network)
                       │  results
                       ▼
        Compose state ──► Canvas overlay (PositionUtils maps
                          image coordinates → preview coordinates)
```

- **One `ImageAnalysis.Analyzer` per model** (`FaceDetectionAnalyzer`, `BarcodeScanningAnalyzer`, ...), each closing the `ImageProxy` once detection finishes so the pipeline never stalls.
- **Coordinate mapping** (`PositionUtils`, `DrawScopeExtensions`) scales and mirrors bounding boxes from the analysis resolution to the on-screen preview.
- **Compose Navigation** with a home screen that links to each model.
- All inference runs **on the device**, so it works offline and no image leaves the phone.

## Tech stack

Kotlin · Jetpack Compose (Material 3) · CameraX (`camera-lifecycle`, `camera-view`) · Google ML Kit · Hilt · Navigation Compose

## Run it

1. Clone the repo and open it in Android Studio.
2. Run on a **physical device** (API 26+). The emulator camera is too limited for most of these models.
3. Grant camera permission and pick a model from the home screen.

---

Built by **[Adarsh Thakur](https://adarsh098765.github.io/adarshthakur.github.io/)**, an Android engineer working with Kotlin and Jetpack Compose · [LinkedIn](https://www.linkedin.com/in/adarsh-thakur-b31281171/)

