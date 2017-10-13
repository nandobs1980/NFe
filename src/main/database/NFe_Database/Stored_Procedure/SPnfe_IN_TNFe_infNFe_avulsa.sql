USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO

/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de Emissão de avulsa
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
ALTER PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_avulsa ( @Id_Arquivo   BIGINT
                                                , @CNPJ         VARCHAR (14)  
                                                , @xOrgao       VARCHAR (60)  
                                                , @matr         VARCHAR (60)  
                                                , @xAgente      VARCHAR (60)  
                                                , @fone         VARCHAR (14)  
                                                , @UF           CHAR (2)  
                                                , @nDAR         VARCHAR (60)  
                                                , @dEmi         SMALLDATETIME  
                                                , @vDAR         DECIMAL (17,2)  
                                                , @repEmi       VARCHAR (60)  
                                                , @dPag         SMALLDATETIME ) 

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
                  , CNPJ      
                  , xOrgao    
                  , matr      
                  , xAgente   
                  , fone      
                  , UF        
                  , nDAR      
                  , dEmi      
                  , vDAR      
                  , repEmi    
                  , dPag 
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @CNPJ      
                  , @xOrgao    
                  , @matr      
                  , @xAgente   
                  , @fone      
                  , @UF        
                  , @nDAR      
                  , @dEmi      
                  , @vDAR      
                  , @repEmi    
                  , @dPag 
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a Identificação do Local de Retirada/Entrega'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_avulsa** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
