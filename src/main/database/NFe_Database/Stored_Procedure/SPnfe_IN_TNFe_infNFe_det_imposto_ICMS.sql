USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO

/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de ICMS
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
ALTER PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_det_imposto_ICMS ( @Id_Arquivo BIGINT  
                                                          , @nItem      INTEGER
                                                          , @Tp_ICMS    VARCHAR (10) 
                                                          , @orig       TINYINT 
                                                          , @CST        VARCHAR (3) 
                                                          , @modBC      TINYINT 
                                                          , @vBC        DECIMAL (15,2)
                                                          , @pICMS      DECIMAL (7,4)
                                                          , @vICMS      DECIMAL (15,2)
                                                          , @pFCP       DECIMAL (7,4) 
                                                          , @vFCP       DECIMAL (15,2) )

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

        INSERT INTO dbo.TNFe_infNFe_det_imposto_ICMS 
                  ( Id_Arquivo 
                  , Id_Empresa
                  , nItem
                  , Tp_ICMS 
                  , orig
                  , CST 
                  , modBC
                  , vBC
                  , pICMS 
                  , vICMS
                  , pFCP
                  , vFCP
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @nItem
                  , @Tp_ICMS 
                  , @orig
                  , @CST 
                  , @modBC
                  , @vBC
                  , @pICMS 
                  , @vICMS
                  , @pFCP
                  , @vFCP
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a ICMS'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_det_imposto_ICMS** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
