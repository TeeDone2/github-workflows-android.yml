package com.jarvisx.services

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.util.Log

class ScreenService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Observe UI events here; you can parse view trees and act.
        if (event != null) {
            Log.d("JarvisX", "Event: ${event.eventType} from ${event.packageName}")
        }
    }

    override fun onInterrupt() {}

    fun tap(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }
        val gesture = GestureDescription.Builder()
            .addStroke(GestureDescription.StrokeDescription(path, 0, 50))
            .build()
        dispatchGesture(gesture, null, null)
    }

    fun findAndClickByText(text: String): Boolean {
        val root: AccessibilityNodeInfo = rootInActiveWindow ?: return false
        val nodes = root.findAccessibilityNodeInfosByText(text)
        if (nodes.isNotEmpty()) {
            nodes[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
            return True
        }
        return false
    }
}