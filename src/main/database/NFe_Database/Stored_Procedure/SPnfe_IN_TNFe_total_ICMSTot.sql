USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO

IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_total_ICMSTot'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_total_ICMSTot
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco ICMS Total
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 23/09/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_total_ICMSTot  ( @Id_Arquivo      BIGINT
                                                 , @vBC             DECIMAL(15,2)
                                                 , @vICMS           DECIMAL (15,2)  
                                                 , @vICMSDeson      DECIMAL (15,2)  
                                                 , @vFCPUFDest      DECIMAL (15,2)  
                                                 , @vICMSUFDest     DECIMAL (15,2)  
                                                 , @vICMSUFRemet    DECIMAL (15,2)  
                                                 , @vFCP            DECIMAL (15,2)  
                                                 , @vBCST           DECIMAL (15,2)  
                                                 , @vST             DECIMAL (15,2)  
                                                 , @vFCPST          DECIMAL (15,2)  
                                                 , @vFCPSTRet       DECIMAL (15,2)  
                                                 , @vProd           DECIMAL (15,2)  
                                                 , @vFrete          DECIMAL (15,2)  
                                                 , @vSeg            DECIMAL (15,2)  
                                                 , @vDesc           DECIMAL (15,2)  
                                                 , @vII             DECIMAL (15,2)  
                                                 , @vIPI            DECIMAL (15,2)  
                                                 , @vIPIDevol       DECIMAL (15,2)  
                                                 , @vPIS            DECIMAL (15,2)  
                                                 , @vCOFINS         DECIMAL (15,2)  
                                                 , @vOutro          DECIMAL (15,2)  
                                                 , @vNF             DECIMAL (15,2)  
                                                 , @vTotTrib        DECIMAL (15,2)) 

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

        INSERT INTO dbo.TNFe_total_ICMSTot 
                  ( Id_Arquivo 
                  , Id_Empresa
                  , vBC
                  , vICMS
                  , vICMSDeson
                  , vFCPUFDest
                  , vICMSUFDest
                  , vICMSUFRemet
                  , vFCP
                  , vBCST
                  , vST
                  , vFCPST
                  , vFCPSTRet
                  , vProd
                  , vFrete
                  , vSeg
                  , vDesc
                  , vII
                  , vIPI
                  , vIPIDevol
                  , vPIS
                  , vCOFINS
                  , vOutro 
                  , vNF
                  , vTotTrib
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo
                  , @Id_Empresa     
                  , @vBC        
                  , @vICMS      
                  , @vICMSDeson  
                  , @vFCPUFDest   
                  , @vICMSUFDest  
                  , @vICMSUFRemet 
                  , @vFCP         
                  , @vBCST        
                  , @vST          
                  , @vFCPST       
                  , @vFCPSTRet    
                  , @vProd        
                  , @vFrete        
                  , @vSeg          
                  , @vDesc       
                  , @vII         
                  , @vIPI        
                  , @vIPIDevol   
                  , @vPIS        
                  , @vCOFINS     
                  , @vOutro      
                  , @vNF         
                  , @vTotTrib
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente ao bloco ICMS Total'   
            GOTO TRATA_ERRO   
        END  

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_total_ICMSTot** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
