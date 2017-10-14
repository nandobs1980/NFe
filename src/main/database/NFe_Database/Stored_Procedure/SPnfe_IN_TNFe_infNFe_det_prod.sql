USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_infNFe_det_prod'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_infNFe_det_prod
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de detalhe do produto
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_det_prod ( @Id_Arquivo BIGINT 
                                                  , @nItem      INTEGER 
                                                  , @cProd      VARCHAR (60)
                                                  , @cEAN       DECIMAL (14) 
                                                  , @xProd      VARCHAR (120)
                                                  , @NCM        DECIMAL (8) 
                                                  , @NVE        VARCHAR (6)
                                                  , @CEST       DECIMAL (7) 
                                                  , @indEscala  CHAR (1)
                                                  , @CNPJFab    DECIMAL (14)
                                                  , @cBenef     VARCHAR (10) 
                                                  , @EXTIPI     DECIMAL (3) 
                                                  , @CFOP       DECIMAL (4) 
                                                  , @uCom       VARCHAR (6)
                                                  , @qCom       DECIMAL (15,4)
                                                  , @vUnCom     DECIMAL (21,11)
                                                  , @vProd      DECIMAL (21,11)
                                                  , @cEANTrib   DECIMAL (14)
                                                  , @uTrib      VARCHAR (6) 
                                                  , @qTrib      DECIMAL (15,4) 
                                                  , @vUnTrib    DECIMAL (21,10) 
                                                  , @vFrete     DECIMAL (15,2)
                                                  , @vSeg       DECIMAL (15,2)
                                                  , @vDesc      DECIMAL (15,2) 
                                                  , @vOutro     DECIMAL (15,2)
                                                  , @indTot     TINYINT 
                                                  , @xPed       VARCHAR (15) 
                                                  , @nItemPed   DECIMAL (6) 
                                                  , @nFCI       VARCHAR (32)) 

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

        INSERT INTO dbo.TNFe_infNFe_det_prod 
                  ( Id_Arquivo
                  , Id_Empresa
                  , nItem
                  , cProd
                  , cEAN
                  , xProd
                  , NCM
                  , NVE
                  , CEST
                  , indEscala
                  , CNPJFab
                  , cBenef
                  , EXTIPI
                  , CFOP
                  , uCom
                  , qCom
                  , vUnCom
                  , vProd
                  , cEANTrib
                  , uTrib
                  , qTrib
                  , vUnTrib
                  , vFrete
                  , vSeg
                  , vDesc
                  , vOutro
                  , indTot
                  , xPed
                  , nItemPed
                  , nFCI
                  , Dt_Inclusao )
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @nItem
                  , @cProd
                  , @cEAN
                  , @xProd
                  , @NCM
                  , @NVE
                  , @CEST
                  , @indEscala
                  , @CNPJFab
                  , @cBenef
                  , @EXTIPI
                  , @CFOP
                  , @uCom
                  , @qCom
                  , @vUnCom
                  , @vProd
                  , @cEANTrib
                  , @uTrib
                  , @qTrib
                  , @vUnTrib
                  , @vFrete
                  , @vSeg
                  , @vDesc
                  , @vOutro
                  , @indTot
                  , @xPed
                  , @nItemPed
                  , @nFCI
                  , getdate() )

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente ao detalhe do produto.'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_det_prod** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
