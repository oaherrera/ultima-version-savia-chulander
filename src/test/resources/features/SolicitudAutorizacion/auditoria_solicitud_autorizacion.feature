Feature: Yo como usuario deseo auditar las solicitudes de autorización las cuales se encuentran en las diferentes bandejas de auditoria

  Background:
    Given me autentico con 800037244_autorizaciones y contraseña conexia2020

  @AprueboLasTecnologiasEnLaSolicitud
  Scenario: Apruebo las tecnologias que se encuentran en estado "Pendiente de Auditoria", de una solicitud de autorización.
    When Consulto las tecnologias para la solicitud Nro: 5677917
    And Ingreso con el Auditor para Aprobar las tecnologias.
    Then Tecnologias de la solicitud en estado Aprobadas consultadas por el usuario 800037244_autorizaciones y contraseña conexia2020

  @RechazoLasTecnologiasEnLaSolicitud
  Scenario: Rechazo las tecnologias que se encuentran en estado "Pendiente de Auditoria", de una solicitud de autorización.
    When Consulto las tecnologias para la solicitud Nro: 5638042
    And Ingreso con el Auditor para Rechazar las tecnologias por motivo: Rechazo excede tope procedimiento
    Then Tecnologias de la solicitud en estado Rechazadas consultadas por el usuario 800037244_autorizaciones y contraseña conexia2020

  @TranscripcionDevolverLasTecnologiasEnLaSolicitud
  Scenario: Rechazo las tecnologias que se encuentran en estado "Pendiente de Auditoria", de una solicitud de autorización.
    When Consulto las tecnologias para la solicitud Nro: 5638042
    And Ingreso con el Auditor para transcribir Devolver las tecnologias por motivo: El servicio solicitado es cobertura del Plan de Beneficios con cargo a la UPC.
    Then Tecnologias de la solicitud en estado Devueltos consultadas por el usuario 800037244_autorizaciones y contraseña conexia2020

  @TranscripcionDerivarLasTecnologiasEnLaSolicitud
  Scenario: Rechazo las tecnologias que se encuentran en estado "Pendiente de Auditoria", de una solicitud de autorización.
    When Consulto las tecnologias para la solicitud Nro: 5677954
    And Ingreso con el Auditor para transcribir Derivar las tecnologias a tipo auditor: Auditor PBS
    Then Tecnologias de la solicitud en estado Derivado consultadas por el usuario 800037244_autorizaciones y contraseña conexia2020