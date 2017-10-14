USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_dest'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_dest
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco Identificação do Destinatário
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_dest ( @Id_Arquivo    BIGINT
                                       , @Id_Doc        VARCHAR (14) 
                                       , @xNome         VARCHAR (60) 
                                       , @xLgr          VARCHAR (60) 
                                       , @nro           VARCHAR (60) 
                                       , @xCpl          VARCHAR (60) 
                                       , @xBairro       VARCHAR (60) 
                                       , @cMun          DECIMAL (7) 
                                       , @xMun          VARCHAR (60) 
                                       , @UF            CHAR (2) 
                                       , @CEP           DECIMAL (8) 
                                       , @cPais         DECIMAL (4)
                                       , @xPais         VARCHAR (60)
                                       , @fone          DECIMAL (14) 
                                       , @indIEDest     SMALLINT 
                                       , @IE            VARCHAR (14) 
                                       , @ISUF          VARCHAR (9)
                                       , @IM            VARCHAR (15) 
                                       , @email         VARCHAR (60)) 

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

        INSERT INTO dbo.TNFe_dest 
                  ( Id_Arquivo  
                  , Id_Empresa  
                  , Id_Doc 
                  , xNome 
                  , xLgr 
                  , nro 
                  , xCpl 
                  , xBairro
                  , cMun 
                  , xMun 
                  , UF
                  , CEP 
                  , cPais
                  , xPais
                  , fone
                  , indIEDest
                  , IE
                  , ISUF
                  , IM
                  , email
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo  
                  , @Id_Empresa  
                  , @Id_Doc 
                  , @xNome 
                  , @xLgr 
                  , @nro 
                  , @xCpl 
                  , @xBairro
                  , @cMun 
                  , @xMun 
                  , @UF
                  , @CEP 
                  , @cPais
                  , @xPais
                  , @fone
                  , @indIEDest
                  , @IE
                  , @ISUF
                  , @IM
                  , @email
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a Identificação do emitente'   
            GOTO TRATA_ERRO   
        END  

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**TNFe_dest** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
