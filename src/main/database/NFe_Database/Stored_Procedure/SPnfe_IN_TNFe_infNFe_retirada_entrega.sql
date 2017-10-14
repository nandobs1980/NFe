USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_infNFe_retirada_entrega'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_infNFe_retirada_entrega
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco Identificação do Local de Retirada/Entrega 
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_retirada_entrega ( @Id_Arquivo             BIGINT 
                                                          , @Id_Empresa             INTEGER 
                                                          , @Id_Retirada_Entrega    CHAR (1)  
                                                          , @Id_Doc                 DECIMAL (14)  
                                                          , @xLgr                   VARCHAR (60)  
                                                          , @nro                    VARCHAR (60)  
                                                          , @xCpl                   VARCHAR (60)  
                                                          , @xBairro                VARCHAR (60)  
                                                          , @cMun                   DECIMAL (7) 
                                                          , @xMun                   VARCHAR (60)  
                                                          , @UF                     CHAR (2) )

AS 
BEGIN 

        SET NOCOUNT ON 
        
        DECLARE @COD_ERRO            INT         -- VARIÁVEL COM O RETORNO DE ERRO   
              , @DESC_ERRO           VARCHAR(800)-- VARIÁVEL COM A DESCRICAO DO ERRO   
              , @INT_RET_PROC        INT         -- VARIÁVEL COM O CÓDIGO DE RETORNO DE ERRO DE PROCS  
        

		-- Recupera o código da empresa com base no Id do arquivo recebido
		DECLARE @Id_Empresa INT
		Set @Id_Empresa = (Select top 1 Id_Empresa
							 from dbo.TSS_Arquivo with (nolock)
						    where Id_Arquivo = @Id_Arquivo)
		
        IF isnull(@Id_Empresa, 0) != 0 BEGIN   
            SET @DESC_ERRO = 'Não foi encontrado nenhuma empresa associado ao arquivo.'   
            GOTO TRATA_ERRO   
        END  

        INSERT INTO dbo.TNFe_infNFe_retirada_entrega 
                  ( Id_Arquivo
                  , Id_Empresa
                  , Id_Retirada_Entrega
                  , Id_Doc
                  , xLgr
                  , nro 
                  , xCpl
                  , xBairro
                  , cMun
                  , xMun
                  , UF
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @Id_Retirada_Entrega
                  , @Id_Doc
                  , @xLgr
                  , @nro 
                  , @xCpl
                  , @xBairro
                  , @cMun
                  , @xMun
                  , @UF
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a Identificação do Local de Retirada/Entrega'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**TNFe_infNFe_retirada_entrega** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
