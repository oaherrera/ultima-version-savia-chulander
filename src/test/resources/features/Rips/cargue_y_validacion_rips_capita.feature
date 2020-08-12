Feature: Cargue de los archivos Rips, y procesamiento de los mismos
  Yo como usuario requiero cargar, procesar y gestionar archivos Rips de la modalidad de Capita

  Background:
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020

  @CargarRipsDeCapita
  Scenario: Carga Archivos rips de modalidad Capita
    When Ingreso al modulo de Cuenta, a Validar RIPS
    And Diligencio el formulario de Cargue y Vaidación de Rips
      | ips                                           | sede                                | mesPrestacion | anhoPrestacion | nroCuenta | valorCuenta | regimen    | controto  | modalidad | responsableDePago | regional |
      | ESE HOSPITAL PADRE CLEMENTE GIRALDO - GRANADA | ESE HOSPITAL PADRE CLEMENTE GIRALDO | Marzo         | 2020           | 896372    | 70276100    | SUBSIDIADO | 0113-2019 | CAPITA    | EPS SAVIA SALUD   | Nacional |
    And Adjunto el o los archivos de Rips y los Cargo
      | archivos                                        |
      | C:/Carga/Load/RIPS/RIPS_CAPITA/RIP_CAPITA_0.zip |
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                           | nroCuenta |
      | ESE HOSPITAL PADRE CLEMENTE GIRALDO - GRANADA | 896372    |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta         |
      | 042    | PENDIENTE VALIDACIÓN |

  @CambioDeEstadoValidadoAPendienteHomologacion
  Scenario: Espero a que la cuenta cambie de estado pendiente validación a estado validado
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el cambio de estado de la cuenta
      | ips                                        | nroCuenta | estadoCuenta         | estadoCuentaEsperado |
      | FUNDACION HOSPITALARIA SAN VICENTE DE PAUL | 896372    | PENDIENTE VALIDACIÓN | VALIDADO             |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta |
      | 896372 | VALIDADO     |

  @GestionarCuentaEnviarAVerificarEPS
  Scenario: Envio la cuenta a verificación con la EPS
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | FUNDACION HOSPITALARIA SAN VICENTE DE PAUL | 896372    |
    And Gestiono la encuenta, Enviar a Verificación EPS
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | FUNDACION HOSPITALARIA SAN VICENTE DE PAUL | 896372    |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta |
      | 896372 | ENVIADO      |

  @RevisarFacturasCuentaEps
  Scenario: Reviso como EPS las facturas de la cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 896372    |
    And Gestiono la encuenta como Eps, Revisión y Devolución de cuentas
    And Marco la cuenta con todas las Facturas como Revisado
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 896372    |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta | estadoCuenta |
      | 896372 | REVISADO     |

  @RegistroCuentaEps
  Scenario: Registro como EPS las cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 896372    |
    And Gestiono la encuenta como Eps, Registrar Cuenta EPS
    And Radico la cuenta con la Eps
      | regional | responsableDePago | Observaciones |
      | Nacional | EPS SAVIA SALUD   | Observaciones |
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 896372    |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta | estadoCuenta      |
      | 896372 | PROCESANDO CUENTA |
