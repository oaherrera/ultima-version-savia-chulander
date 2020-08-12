Feature: Ralizar la gestion del radicado hasta poder llegar
  a la liquidación de la cuenta, cargada en rips.

  @LegalizarCuenta
  Scenario: Legalizar la cuenta con la Eps
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    And Gestiono la encuenta como Eps, Legalizar Cuenta
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      | 2160686   |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta  | estadoCuenta |
      | 2160686 | RADICADO     |

  @GeneroGlosaTotalRadicadoTodasLasFacturas
  Scenario: Genero glosa total a nivel radicado, todas las facturas
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Marco todas las facturas a glosar
    And Genero glosa a todas las facuras con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado                   |
      | Facturación  | 06 Materiales                | Total         | Pruebas 1     | 0                 | S       |                                   |
      | Tarifas      | 08 Ayudas diagnósticas       | Total         | Pruebas 2     | 0                 | S       |                                   |
      | Soportes     | 32 Detalle de cargos         | Total         | Pruebas 3     | 0                 | S       |                                   |
      | Devoluciones | 17 Usuario retirado o moroso | Total         | Pruebas 4     | 0                 | S       |                                   |
      | Pertinencia  | 01 Estancia                  | Total         | Pruebas 5     | 0                 | S       |                                   |
      | Cobertura    | 45 Servicio no pactado       | Total         | Pruebas 6     | 0                 | N       | No se puede adicionar mas motivos |
    Then Se despliega el mensaje temporal: Registro exitoso

  @LevantoGlosaRadicadoTodasLasFacturas
  Scenario: Levanto glosa a nivel radicado, todas las facturas
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Marco todas las facturas a glosar
    And Levanto la glosa a todas las facturas, con el motivo: Pertinencia de diagnóstico
    Then Se despliega el mensaje temporal: Registro exitoso

  @GeneroGlosaParcialRadicadoTodasLasFacturas
  Scenario: Genero glosa parcial a nivel radicado, todas las facturas
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Marco todas las facturas a glosar
    And Genero glosa a todas las facuras con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado                   |
      | Facturación  | 06 Materiales                | Parcial       | Pruebas 1     | 50                | S       |                                   |
      | Tarifas      | 08 Ayudas diagnósticas       | Parcial       | Pruebas 2     | 50                | S       |                                   |
      | Soportes     | 32 Detalle de cargos         | Parcial       | Pruebas 3     | 50                | S       |                                   |
      | Devoluciones | 17 Usuario retirado o moroso | Parcial       | Pruebas 4     | 50                | S       |                                   |
      | Pertinencia  | 01 Estancia                  | Parcial       | Pruebas 5     | 50                | S       |                                   |
      | Cobertura    | 45 Servicio no pactado       | Parcial       | Pruebas 6     | 50                | N       | No se puede adicionar mas motivos |
    Then Se despliega el mensaje temporal: Registro exitoso

  @GeneroGlosaMasivaParcialRadicado
  Scenario: Genero glosa masiva parcial.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Filtro las tecnologias aplicar glosa a la factura
      | tipo          | codigo      | descripcion                                            |
      | Procedimiento | S43100      | SERVICIO DE ESTERILIZACION DE COMPLEJIDAD BAJA SOD     |
      | Medicamento   | 19940721-13 | HIDROCORCCSONA - POLVO LIOFILIZADO PA - A - MILIGRAMOS |
    And Genero glosa masiva con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado |
      | Facturación  | 06 Materiales                | Parcial       | Pruebas 1     | 50                | S       |                 |
      | Tarifas      | 08 Ayudas diagnósticas       | Parcial       | Pruebas 2     | 50                | S       |                 |
      | Soportes     | 32 Detalle de cargos         | Parcial       | Pruebas 3     | 50                | S       |                 |
      | Devoluciones | 17 Usuario retirado o moroso | Parcial       | Pruebas 4     | 50                | S       |                 |
      | Pertinencia  | 01 Estancia                  | Parcial       | Pruebas 5     | 50                | S       |                 |
    Then Se despliega el mensaje temporal: Registro exitoso

  @LevantoGlosaMasiva
  Scenario: Levanto glosa a nivel Masiva.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Filtro las tecnologias para levantar glosa a la factura
      | tipo          | codigo      | descripcion                                            |
      | Procedimiento | S43100      | SERVICIO DE ESTERILIZACION DE COMPLEJIDAD BAJA SOD     |
      | Medicamento   | 19940721-13 | HIDROCORCCSONA - POLVO LIOFILIZADO PA - A - MILIGRAMOS |
    And Levanto la glosa masiva, con el motivo: Pertinencia de diagnóstico
    Then Se despliega el mensaje temporal: Registro exitoso

  @GeneroGlosaMasivaTotalRadicado
  Scenario: Genero glosa masiva total.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Filtro las tecnologias aplicar glosa a la factura
      | tipo          | codigo      | descripcion                                            |
      | Procedimiento | S43100      | SERVICIO DE ESTERILIZACION DE COMPLEJIDAD BAJA SOD     |
      | Medicamento   | 19940721-13 | HIDROCORCCSONA - POLVO LIOFILIZADO PA - A - MILIGRAMOS |
    And Genero glosa masiva con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado |
      | Facturación  | 06 Materiales                | Total         | Pruebas 1     | 0                 | S       |                 |
      | Tarifas      | 08 Ayudas diagnósticas       | Total         | Pruebas 2     | 0                 | S       |                 |
      | Soportes     | 32 Detalle de cargos         | Total         | Pruebas 3     | 0                 | S       |                 |
      | Devoluciones | 17 Usuario retirado o moroso | Total         | Pruebas 4     | 0                 | S       |                 |
      | Pertinencia  | 01 Estancia                  | Total         | Pruebas 5     | 0                 | S       |                 |
    Then Se despliega el mensaje temporal: Registro exitoso

  @GeneroGlosaPorItemParcialRadicado
  Scenario: Genero glosa parcial por Item.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Selecciono uno de los servicios de la primera factura
    And Genero glosa por Item con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado |
      | Facturación  | 06 Materiales                | Parcial       | Pruebas 1     | 50                | S       |                 |
      | Tarifas      | 08 Ayudas diagnósticas       | Parcial       | Pruebas 2     | 50                | S       |                 |
      | Soportes     | 32 Detalle de cargos         | Parcial       | Pruebas 3     | 50                | S       |                 |
      | Devoluciones | 17 Usuario retirado o moroso | Parcial       | Pruebas 4     | 50                | S       |                 |
      | Pertinencia  | 01 Estancia                  | Parcial       | Pruebas 5     | 50                | S       |                 |
    Then Se despliega el mensaje temporal: Registro exitoso

  @LevantoGlosaPorItem
  Scenario: Levanto glosa a nivel de Item.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Selecciono uno de los servicios de la primera factura
    And Levanto la glosa por item, con el motivo: Pertinencia de diagnóstico
    Then Se despliega el mensaje temporal: Registro exitoso

  @GeneroGlosaPorItemTotalRadicado
  Scenario: Genero glosa total por Item.
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña conexia2020
    And Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    When Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Radicado en estado Pendiente auditoría en listas de trabajo radicado
    Then Realizo la accion Ver Detalle en listas de trabajo
    And Selecciono uno de los servicios de la primera factura
    And Genero glosa por Item con los siguientes datos
      | motivoGlosa  | motivoCodigo                 | totalOParcial | justificacion | parcialValorGlosa | exitoso | mensajeEsperado |
      | Facturación  | 06 Materiales                | Total         | Pruebas 1     | 0                 | S       |                 |
      | Tarifas      | 08 Ayudas diagnósticas       | Total         | Pruebas 2     | 0                 | S       |                 |
      | Soportes     | 32 Detalle de cargos         | Total         | Pruebas 3     | 0                 | S       |                 |
      | Devoluciones | 17 Usuario retirado o moroso | Total         | Pruebas 4     | 0                 | S       |                 |
      | Pertinencia  | 01 Estancia                  | Total         | Pruebas 5     | 0                 | S       |                 |

  @MarcarCuentasRevisadas
  Scenario: Marco como revisadas las facturas en Listas de trabajo
    Given me autentico con audliqreg y contraseña conexia2017
    When Ingreso al modulo de Liquidación de Prestaciones, a Lista de trabajo radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Realizo la accion Ver Detalle en listas de trabajo
    And Diligenciar Opciones de Factura Informacion complementaria
      | codDiagnostico | aplicaPBS | centroDeCosto    | altoCosto | aplicaNOPBS |
      | A2160686       | Si        | MEDICINA GENERAL | No        | No          |
    And Marco todas las facturas como revisadas
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    Then Radicado en estado Revisada en listas de trabajo radicado

  @AsignoAusitoryLiquidador
  Scenario: Asigno al auditor y al liquedador en la bandeja de Radicado
    Given me autentico con tatiana.puerta@saviasaludeps.com y contraseña conexia2020
    When Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Realizo la accion Asignar en listas de trabajo
    And Asigno a TATIANA MARIA PUERTA GUZMAN, de la Regional: Nacional, con el cargo: Auditor médico
    And Asigno a VIVIANA ANDREA MIRANDA OCAMPO, de la Regional: Nacional, con el cargo: Jefe liquidación
    Then Puedo ver a CRISTIAN ARLEY OSPINA SALAZAR, en asignación actual
    And Puedo ver a VIVIANA ANDREA MIRANDA OCAMPO, en asignación actual

  @FinalizarAuditoriaAuditorMedico
  Scenario: Finalizar la auditoria con el auditor Medico
    Given me autentico con tatiana.puerta@saviasaludeps.com y contraseña conexia2020
    When Ingreso al modulo de Liquidación de Prestaciones, a Lista de trabajo radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Realizo la accion Finalizar Auditoria en listas de trabajo
    And Ingreso al modulo deplegado de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    Then Radicado en estado Pendiente liquidación en listas de trabajo radicado

  @CierreDeCuentaLiquidador
  Scenario: Cierra la cuenta con el usuario liquidador
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña 1017142017
    When Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    And Realizo la accion Ver Detalle en listas de trabajo
    And Cierro la cuenta y confirmo cierre de cuenta
    And Ingreso al modulo deplegado de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro | 2160686       |
      | Radicado             | 5807          |
    Then Radicado en estado Liquidado en listas de trabajo radicado
