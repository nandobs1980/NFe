USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_infNFe_det_imposto_IPI'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_infNFe_det_imposto_IPI
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de IPI
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_det_imposto_IPI ( @Id_Arquivo  BIGINT 
                                                         , @nItem       INTEGER 
                                                         , @clEnq       VARCHAR (5) 
                                                         , @CNPJProd    DECIMAL (14)
                                                         , @cSelo       VARCHAR (60) 
                                                         , @qSelo       DECIMAL (12)
                                                         , @cEnq        VARCHAR (3)
                                                         , @CST         VARCHAR (3)
                                                         , @vBC         DECIMAL (15,2)
                                                         , @pIPI        DECIMAL (7,4)
                                                         , @qUnid       DECIMAL (16,4)
                                                         , @vUnid       DECIMAL (15,4)
                                                         , @vIPI        DECIMAL (15,2) )

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

        INSERT INTO dbo.TNFe_infNFe_det_imposto_IPI 
                  ( Id_Arquivo
                  , Id_Empresa
                  , nItem     
                  , clEnq     
                  , CNPJProd  
                  , cSelo     
                  , qSelo     
                  , cEnq      
                  , CST       
                  , vBC       
                  , pIPI      
                  , qUnid     
                  , vUnid     
                  , vIPI 
                  , Dt_Inclusao )
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @nItem     
                  , @clEnq     
                  , @CNPJProd  
                  , @cSelo     
                  , @qSelo     
                  , @cEnq      
                  , @CST       
                  , @vBC       
                  , @pIPI      
                  , @qUnid     
                  , @vUnid     
                  , @vIPI      
                  , getdate() )

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a IPI'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_det_imposto_IPI** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
