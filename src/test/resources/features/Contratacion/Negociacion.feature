@TODO
Feature: Negociación

  Background: 
    Given me autentico con contratacion y contraseña conexia..2020
    And Ingreso al modulo de Precontractual, a Negociación
    And Busco al prestador METROSALUD para Ver Negociaciones.

  @CreoNegociacionEvento
  Scenario: Deseo crear una negociación con la modalidad Evento
    When Creo la base negociacion
      | prestador  | modalidad | regimen    | poblacion | complejidad |
      | METROSALUD | Evento    | Subsidiado |     20000 | Alta        |
    And Asigno area de cobertura
      | areaCobertura                                     | nombreSede                                           | sedePrincipal |
      | Asignar municipios de acuerdo a tabla de general: | UNIDAD HOSPITALARIA DE MANRRIQUE HERMENEGILDO DE FEX |               |
      | Asignar municipios de acuerdo a tabla de general: | CENTRO DE SALUD TRINIDAD                             | X             |
    And Selecciono un tipo de negociación: Negociar todas las sedes.
    Then Se despliegua el detalle de la negociación.

  @CreoNegociacionCapita
  Scenario: Deseo crear una negociación con la modalidad Capita
    When Creo la base negociacion
      | modalidad | regimen      | poblacion | complejidad |
      | Cápita    | Contributivo |         0 | Media       |
    And Asigno area de cobertura
      | areaCobertura                                     | nombreSede                | sedePrincipal |
      | Asignar municipios de acuerdo a tabla de general: | CENTRO DE SALUD ESTADIO   |               |
      | Asignar municipios de acuerdo a tabla de general: | CENTRO DE SALUD VILLATINA | X             |
    And Selecciono un tipo de negociación: Negociar todas las sedes.
    Then Se despliegua el detalle de la negociación.

  @CargoTecnologiasEventoMasivo
  Scenario: Cargo las tecnologias masivamente para modalidad evento
    When Consulto la negociacion nro 1405, para Ver negociación
    And Importo las tecnologias
      | tecnologia   | archovACargar                                                                      |
      | Medicamentos | C:/Users/familia/eclipse-workspace/Savia-Serenity/Cargas/importarMedicamentos.xlsx |
      | Insumos      | C:/Users/familia/eclipse-workspace/Savia-Serenity/Cargas/importar_insumo.xlsx      |
