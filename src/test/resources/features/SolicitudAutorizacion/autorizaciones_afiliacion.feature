Feature: Solicitudes Autorizacion para afiliacion
  Yo como usuario requiero crear solicitudes de autorizacion de los siguientes tipos:
  Autorizacion PBS, Autorizacion No PBS, Autorizacion PBS Condicionada

  Background:
    Given me autentico con 800037244_autorizaciones y contraseña conexia2020
      And Consulto afiliado con Cédula de ciudadanía Nro 15672015 en Autorizaciones

  @autorizacionPBS
  Scenario Outline: Creo solicitud autorización con las tecnologias (Procedimientos, Medicamentos, Insumos y paquetes )de tipo PBS
    When Diligencio el formulario de autorizaciones con los datos:
      | nombreAcompanhante | telefonoFijoAcompanhante | celularAcompanhante | servicio | programa | nroSolicitud |
    And Asocio la sede de la ips con razon social
      | sede | ipsRazonSocial |
    And Asigno el profesional identificado con:
      | tipoDocumentoProfesional | numeroDocumentoProfesional |
    And Selecciono servicios solicitados.
      | origenDeLaAtencion | prioridadDeLaAntencion | tipoDeServicioSolicitado | ubicacionDelPaciente |
    And Asocio Diagnostico.
      | codigoDiagnostico | descripcionDiagnostico | tipoDiagnostico |
    And Agrego procedimiento.
      | tipologiaProcedimiento | codigoProcedimiento | descripcionProcedimiento | duracionTratamientoProcedimiento | indicacionesProcedimiento |
    And Agrego medicamento.
      | tipologiaMedicamento | codigoMedicamento | descripcionMedicamento | codigoDiagnostico | causaExternaMedicamento | finalidadMedicamento | tipoCatastroficoMedicamento | dosisMedicamento | frecuenciaMedicamento | frecuenciaTipoMedicamento | viaDeAdministracionMedicamento | duracionTratamientoMedicamento | posologiaMedicamento |
    And Agrego insumo.
      | tipologiaInsumo | codigoInsumo | descripcionInsumo | codigoDiagnostico | duracionTratamientoInsumo |
    And Agrego paquete.
      | tipologiaPaquete | codigoPaquete | descripcionPaquete | codigoDiagnostico | duracionTratamientoPaquete | indicacionesPaquete |
    And Diligencio campos complementarios de la autorizacion
      | justificacionClinica | historiaClinica |
    And Ajunto soporte fisico formato PDF.
      | rutaArchivo | tipoArchivo |
    And Envio la solicitud a Validar
    Then Se debe generar una solicitud de afiliacion anexo4

    Examples:
      | data |
      ##@externaldata@./src/test/resources/data/Autorizaciones/Autorizaciones.xlsx@PBS

  @autorizacionNoPBS
  Scenario Outline: Creo solicitud autorización con las tecnologias (Procedimientos, Medicamentos, Insumos y paquetes )de tipo No PBS
    When Diligencio el formulario de autorizaciones con los datos:
      | nombreAcompanhante | telefonoFijoAcompanhante | celularAcompanhante | servicio | programa | nroSolicitud |
    And Asocio la sede de la ips con razon social
      | sede | ipsRazonSocial |
    And Asigno el profesional identificado con:
      | tipoDocumentoProfesional | numeroDocumentoProfesional |
    And Selecciono servicios solicitados.
      | origenDeLaAtencion | prioridadDeLaAntencion | tipoDeServicioSolicitado | ubicacionDelPaciente |
    And Asocio Diagnostico.
      | codigoDiagnostico | descripcionDiagnostico | tipoDiagnostico |
    And Agrego procedimiento.
      | tipologiaProcedimiento | codigoProcedimiento | descripcionProcedimiento |
    And Agrego medicamento.
      | tipologiaMedicamento | codigoMedicamento | descripcionMedicamento | codigoDiagnostico |
    And Agrego insumo.
      | tipologiaInsumo | codigoInsumo | descripcionInsumo | codigoDiagnostico |
    And Agrego paquete.
      | tipologiaPaquete | codigoPaquete | descripcionPaquete | codigoDiagnostico |
    And Diligencio campos complementarios de la autorizacion
      | justificacionClinica | historiaClinica |
    And Ajunto soporte fisico formato PDF.
      | rutaArchivo | tipoArchivo |
    And Envio la solicitud a Validar
    Then Se debe generar una solicitud de afiliacion anexo4

    Examples:
      | data |
      ##@externaldata@./src/test/resources/data/Autorizaciones/Autorizaciones.xlsx@NO_PBS

  @autorizacionCondicionada
  Scenario Outline: Creo solicitud autorización con las tecnologias (Procedimientos, Medicamentos, Insumos y paquetes )de tipo PBS Condicionada
    When Diligencio el formulario de autorizaciones con los datos:
      | nombreAcompanhante | telefonoFijoAcompanhante | celularAcompanhante | servicio | programa | nroSolicitud |
    And Asocio la sede de la ips con razon social
      | sede | ipsRazonSocial |
    And Asigno el profesional identificado con:
      | tipoDocumentoProfesional | numeroDocumentoProfesional |
    And Selecciono servicios solicitados.
      | origenDeLaAtencion | prioridadDeLaAntencion | tipoDeServicioSolicitado | ubicacionDelPaciente |
    And Asocio Diagnostico.
      | codigoDiagnostico | descripcionDiagnostico | tipoDiagnostico |
    And Agrego procedimiento.
      | tipologiaProcedimiento | codigoProcedimiento | descripcionProcedimiento | duracionTratamientoProcedimiento | indicacionesProcedimiento |
    And Agrego medicamento.
      | tipologiaMedicamento | codigoMedicamento | descripcionMedicamento | codigoDiagnostico | causaExternaMedicamento | finalidadMedicamento | tipoCatastroficoMedicamento | dosisMedicamento | frecuenciaMedicamento | frecuenciaTipoMedicamento | viaDeAdministracionMedicamento | duracionTratamientoMedicamento | posologiaMedicamento |
    And Agrego insumo.
      | tipologiaInsumo | codigoInsumo | descripcionInsumo | codigoDiagnostico | duracionTratamientoInsumo |
    And Agrego paquete.
      | tipologiaPaquete | codigoPaquete | descripcionPaquete | codigoDiagnostico | duracionTratamientoPaquete | indicacionesPaquete |
    And Diligencio campos complementarios de la autorizacion
      | justificacionClinica | historiaClinica |
    And Ajunto soporte fisico formato PDF.
      | rutaArchivo | tipoArchivo |
    And Envio la solicitud a Validar
    Then Se debe generar una solicitud de afiliacion anexo4

    Examples:
      | data |
      ##@externaldata@./src/test/resources/data/Autorizaciones/Autorizaciones.xlsx@CONDICIONADA
