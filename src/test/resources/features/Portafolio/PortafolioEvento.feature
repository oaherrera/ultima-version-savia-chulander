Feature: Gestiono el portafolio de la IPS.

  Background:
    Given me autentico con 890981182_contractual y contraseña conexia2020

  @AgregoProcedimientoAlPortafolio
  Scenario: Agrego servicio de procedimiento a la sede del portafolio evento.
    Given Ingreso al modulo de Portafolio, a Portafolio evento
    When Selecciono sedes del prestador para Editar Servicios Sede, de la sede: ESE HOSPITAL PADRE CLEMENTE GIRALDO
    And Agrego un nuevo servicio con procedimiento
      | descripcionGrupoServicio | codigoServicio | descripcionServicio         | tarifario     | porcentajeNegociado | complejidad | codigoProcedimiento | descripcionProcedimiento                             | valorProcedimiento |
      | QUIRURGICOS              | 237            | CIRUGIA PLASTICA ONCOLOGICA | TARIFA PROPIA | 1                   | Alto        | 857204              | RECONSTRUCCION DE MAMA BILATERAL CON TEJIDO AUTOLOGO | 10000              |
    Then Se agrega el servicio de procedimiento al portafolio evento

  @AgregoMedicamentoAlPortafolio
  Scenario: Agrego servicio de procedimiento a la sede del portafolio evento.
    Given Ingreso al modulo de Portafolio, a Portafolio evento
    When Selecciono sedes del prestador para Editar Servicios Sede, de la sede: ESE HOSPITAL PADRE CLEMENTE GIRALDO
    And Agrego un nuevo medicamento
      | descripcionGrupoServicio | codigoServicio | descripcionServicio         | tarifario     | porcentajeNegociado | complejidad | codigoProcedimiento | descripcionProcedimiento                             | valorProcedimiento |
      | QUIRURGICOS              | 237            | CIRUGIA PLASTICA ONCOLOGICA | TARIFA PROPIA | 1                   | Alto        | 857204              | RECONSTRUCCION DE MAMA BILATERAL CON TEJIDO AUTOLOGO | 10000              |
    Then Se agrega el servicio de procedimiento al portafolio evento

