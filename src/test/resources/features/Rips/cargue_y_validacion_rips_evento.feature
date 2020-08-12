Feature: Cargue de los archivos Rips, y procesamiento de los mismos
  Yo como usuario requiero cargar, procesar y gestionar archivos Rips de la modalidad Evento

  Background:
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020

  @CargarRipsDeEvento
  Scenario: Carga Archivos rips de modalidad Evento
    When Ingreso al modulo de Cuenta, a Validar RIPS
    And Diligencio el formulario de Cargue y Vaidación de Rips
      | ips                                        | sede                            | mesPrestacion | anhoPrestacion | nroCuenta | valorCuenta | regimen    | controto  | modalidad | responsableDePago | regional |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | ESE HOSPITAL VENANCIO DIAZ DIAZ | Noviembre     | 2019           | 2160686   | 15314576    | SUBSIDIADO | 0069-2019 | EVENTO    | EPS SAVIA SALUD   | Nacional |
    And Es multiusuario: Si
    And Adjunto el o los archivos de Rips y los Cargo
      | archivos                                        |
      | C:/Carga/Load/RIPS/RIPS_EVENTO/RIP_EVENTO_0.zip |
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    Then La cuenta se encuentra en estado
      | cuenta  | estadoCuenta         |
      | 2160686 | PENDIENTE VALIDACIÓN |

  @CambioDeEstadoValidadoAPendienteHomologacion
  Scenario: Espero a que la cuenta cambie de estado pendiente validación a estado validado
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el cambio de estado de la cuenta
      | ips                                        | nroCuenta | estadoCuenta         | estadoCuentaEsperado |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   | PENDIENTE VALIDACIÓN | VALIDADO             |
    Then La cuenta se encuentra en estado
      | cuenta  | estadoCuenta |
      | 2160686 | VALIDADO     |

  @GestionarCuentaEnviarHomologar
  Scenario: Envio la cuenta validada a Homologacion
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    And Gestiono la encuenta, Enviar a homologar
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    Then La cuenta se encuentra en estado
      | cuenta  | estadoCuenta           |
      | 2160686 | PENDIENTE HOMOLOGACION |

  @GestionarCuentaFinalizarHomologacion
  Scenario: Finalizo proceso de homologación
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    And Gestiono la encuenta, Finalizar homologación
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    Then La cuenta se encuentra en estado
      | cuenta  | estadoCuenta           |
      | 2160686 | HOMOLOGACION TERMINADA |

  @GestionarCuentaEnviarAVerificarEPS
  Scenario: Envio la cuenta a verificación con la EPS
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    And Gestiono la encuenta, Enviar a Verificación EPS
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                        | nroCuenta |
      | ESE HOSPITAL VENANCIO DIAZ DIAZ - SABANETA | 2160686   |
    Then La cuenta se encuentra en estado
      | cuenta  | estadoCuenta |
      | 2160686 | ENVIADO      |

  @RevisarFacturasCuentaEps
  Scenario: Reviso como EPS las facturas de la cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    And Gestiono la encuenta como Eps, Revisión y Devolución de cuentas
    And Marco la cuenta con todas las Facturas como Revisado
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta  | estadoCuenta |
      | 2160686 | REVISADO     |

  @RegistroCuentaEps
  Scenario: Registro como EPS las cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    And Gestiono la encuenta como Eps, Registrar Cuenta EPS
    And Radico la cuenta con la Eps
      | regional | responsableDePago | Observaciones |
      | Nacional | EPS SAVIA SALUD   | Observaciones |
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta  | estadoCuenta      |
      | 2160686 | PROCESANDO CUENTA |
