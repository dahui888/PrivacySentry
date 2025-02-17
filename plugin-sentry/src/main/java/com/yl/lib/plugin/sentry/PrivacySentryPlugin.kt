package com.yl.lib.plugin.sentry

import com.android.build.gradle.AppExtension
import com.yl.lib.plugin.sentry.extension.PrivacyExtension
import com.yl.lib.plugin.sentry.transform.PrivacySentryTransform
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author yulun
 * @sinice 2021-12-13 17:05
 */
class PrivacySentryPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        //只在application下生效
        if (!target.plugins.hasPlugin("com.android.application")) {
            return
        }
        target.extensions.create("privacy", PrivacyExtension::class.java)
        var android = target.extensions.getByType(AppExtension::class.java)
        android?.registerTransform(PrivacySentryTransform(target))
    }
}