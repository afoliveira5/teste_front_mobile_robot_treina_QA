*** Settings ***

Library    AppiumLibrary

*** Variables ***

${liberar1}                         br.com.quantaPrevidencia.debug:id/securityTimeSwitch        
${liberar2}                         /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Switch[2]
${liberar3}                         /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Switch[3]
${continuartoggle}                  br.com.quantaPrevidencia.debug:id/btn_continue
               
