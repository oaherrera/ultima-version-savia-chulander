Feature: Yo como usuario deseo cargar un archivo de carga masvia de solicitudes afiliado.

  Background:
    Given me autentico con 800037244_autorizaciones y contraseña conexia2020

  @cargueArchivoCorrecto
  Scenario: Cargo y proceso archivo masivo solicitudes correctamente.
    When Cargo archivo masivo de solicitud.
      | rutaArchivo                                      |
      | C:/Carga/Load/CargueSolicitudesMasivosCarga.xlsx |
    And Proceso el cargue de archivo solicitud.
    Then Proceso de cargue de archivo solicitud en estado Procesado.