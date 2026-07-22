
*** Settings ***

Library    AppiumLibrary

*** Variables ***

${btn_atualizacao_cadastral}                             //android.widget.TextView[@text="Atualização Cadastral"]
#${btn_atualizacao_cadastral}                             //android.view.View[@content-desc="Atualize seus Dados"]

#${Atualizacao_cadastral_tela}                        //android.widget.TextView[@text="Atualização Cadastral"]
${btn_continua_atualizacao_cadastral}                //android.widget.ScrollView/android.view.View/android.widget.Button
${dados_basicos_tela}                                //android.widget.TextView[@text="Dados Básicos"]
${combo_box_estado_civil}                            //android.widget.ScrollView/android.view.View[2]
${option_combo_box_estado_civil}                     //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[6]
${combo_box_profissao}                               //android.widget.ScrollView/android.view.View[3]
${option_combo_box_profissao}                        //android.widget.TextView[@text="ADMINISTRADOR DE BANCO DE DADOS"]
${campo_renda_mensal}                                //android.widget.EditText[@text="R$ 1,234.56"]
${campo_renda_mensal_clean}                          //android.widget.EditText[@text="R$ 0.00"]
${btn_Continuar_dados_basico}                        //android.widget.ScrollView/android.view.View[4]/android.widget.Button
${PPE_tela}                                          //android.widget.TextView[@text="PPE"]
${Radio_buton_PPE_sim}                               //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.RadioButton
${Radio_buton_PPE_nao}                               //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.widget.RadioButton
${btn_continuar_ppe}                                 //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.Button
${btn_voltar_para_dados_basicos}                     //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[5]/android.widget.Button
${contato_email}                                     //android.widget.EditText[@text="06390796951@mailinator.com"]
${contato_celular}                                   //android.widget.EditText[@text="(47) 98819-3042"]
${btn_continuar_para_PPE}                            //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button
${btn_voltar_contatos}                               //androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.widget.Button
${codigo_de_verificacao_email}                       br.com.quantaPrevidencia.homolog:id/toggleButtonEmail
${campo_codigo_de_verificacao_email}                 br.com.quantaPrevidencia.homolog:id/codeEditText
${btn_continuar_verificacao}                         br.com.quantaPrevidencia.homolog:id/validateCodeButton

${renda_mensal}                                      123456789







${cpf}                              13241824900


