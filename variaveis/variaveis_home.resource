*** Settings ***

Library    AppiumLibrary

*** Variables ***

${botaoSaldoExtratoHome}               //android.widget.Button[@resource-id="br.com.quantaPrevidencia.homolog:id/button_statement"]
${carrosel2}                           //android.widget.HorizontalScrollView[@resource-id="br.com.quantaPrevidencia.homolog:id/profileSummaryViewPagerTabLayout"]/android.widget.LinearLayout/android.widget.LinearLayout[2]
${carrosel3}                           //android.widget.HorizontalScrollView[@resource-id="br.com.quantaPrevidencia.homolog:id/profileSummaryViewPagerTabLayout"]/android.widget.LinearLayout/android.widget.LinearLayout[3]
${perfil_de_investimeto}               br.com.quantaPrevidencia.homolog:id/button_consult_profitability
${saiba_quanto_economizar}             br.com.quantaPrevidencia.homolog:id/button_tax_incentive
${tela_do_adequar_perfil_Title}        //android.widget.TextView[@text="Adequar Perfil"]
${adequar_perfil_title_mensager}       Adequar Perfil
${pague_menos_imposto}                 br.com.quantaPrevidencia.homolog:id/pay_less_taxes_title
${pague_menos_imposto_message}         Pague menos Imposto de Renda
${carrosel_faça_acontecer_message}     //android.widget.TextView[@resource-id="br.com.quantaPrevidencia.homolog:id/text_make_happen"]
${comprar_plano}                       br.com.quantaPrevidencia.homolog:id/button_compare_plans
${comprar_plano_tela}                  br.com.quantaPrevidencia.homolog:id/textHomeDesc
${carrosel_faça_acontecer_2}           //android.widget.HorizontalScrollView[@resource-id="br.com.quantaPrevidencia.homolog:id/tab_layout_make_happen"]/android.widget.LinearLayout/android.widget.LinearLayout[2]
${contribuicao_extra}                  br.com.quantaPrevidencia.homolog:id/image_start_boost_balance
${contribuicao_extra_tela}             br.com.quantaPrevidencia.homolog:id/tv_contribution
${carrosel_faça_acontecer_3}           //android.widget.HorizontalScrollView[@resource-id="br.com.quantaPrevidencia.homolog:id/tab_layout_make_happen"]/android.widget.LinearLayout/android.widget.LinearLayout[3]
${objetivo_futuro}                     //androidx.viewpager.widget.ViewPager[@resource-id="br.com.quantaPrevidencia.homolog:id/recycler_make_happen"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.ImageView[4]
${objetivo_futuro_tela}                br.com.quantaPrevidencia.homolog:id/title

${carrosel_aposentadoria}                       br.com.quantaPrevidencia.homolog:id/textRetirementTitle
${contribuicao_mensal_aposentadoria}            br.com.quantaPrevidencia.homolog:id/imgEditCurrentMonthlyContributionValue
${contribuicao_mensal_aposentadoria_tela}    	br.com.quantaPrevidencia.homolog:id/change_contribution_title
${idade_da_aposentadoria}                       br.com.quantaPrevidencia.homolog:id/imgEditRetirementAgeValue
${idade_da_aposentadoria_modal}                 br.com.quantaPrevidencia.homolog:id/text_title
${carrosel_aposentadoria_2}                     //android.widget.HorizontalScrollView[@resource-id="br.com.quantaPrevidencia.homolog:id/tabLayoutRetirement"]/android.widget.LinearLayout/android.widget.LinearLayout[2]
${aposentadoria_quero_esta_renda_btn}           //android.widget.FrameLayout[@resource-id="br.com.quantaPrevidencia.homolog:id/retirementItemCurrentCardView"]/android.view.ViewGroup/android.widget.LinearLayout
${aposentadoria_quero_esta_renda_modal}         br.com.quantaPrevidencia.homolog:id/text_subtitl${carrosel_protecao_familiar}                br.com.quantaPrevidencia.homolog:id/riskCoverageViewPager


${carrosel_beneficiario}


${carrosel_fique_de_olho}