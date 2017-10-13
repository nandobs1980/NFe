USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO

/********************************************************************************************************************** 
 Objetivo..........: Inserir dados do Arquivo XML
 Parâmetros........: @Id_Arquivo (output) - Retorna o Id do arquivo gravado 
 Autor.............: Fernando Souza
 Criação...........: 23/09/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
ALTER PROCEDURE dbo.SPnfe_IN_ArquivoXML  ( @Id_Empresa int
                                         , @FileNameXML varchar(200)
                                		 , @pathXML varchar(800)
                                         , @Dt_Criacao datetime
                                		 , @Dt_Ultimo_Acesso datetime
                                	     , @Dt_Modificacao datetime
                                		 , @Tamanho decimal(20)
                                		 , @ArquivoXML Text
                                		 , @Id_Arquivo int output) 

AS 

BEGIN 

        SET NOCOUNT ON 
        
        DECLARE @COD_ERRO            INT         -- VARIÁVEL COM O RETORNO DE ERRO   
              , @DESC_ERRO           VARCHAR(800)-- VARIÁVEL COM A DESCRICAO DO ERRO   
              , @INT_RET_PROC        INT         -- VARIÁVEL COM O CÓDIGO DE RETORNO DE ERRO DE PROCS 
              , @Ds_Log              Text        -- VARIÁVEL COM A DESCRIÇÃO DO LOG 
        
        /* VERIFICA SE JÁ EXISTE UM ARQUIVO COM O MESMO NOME */
        IF (SELECT COUNT(1) 
              FROM dbo.TSS_Arquivo WITH (NOLOCK)
              WHERE Id_Empresa = @Id_Empresa
                AND FileNameXML = @FileNameXML) > 0
        BEGIN
            SET @Ds_Log = 'Já existe um arquivo (' + @FileNameXML + ') com este nome'
            EXECUTE dbo.SPnfe_IN_TSS_Log 'SPnfe_IN_ArquivoXML', 1, @Ds_Log
        END

        INSERT INTO dbo.TSS_Arquivo 
                  ( Id_Empresa
                  , Dt_Inclusao
                  , XML_Arquivo
                  , FileNameXML
                  , pathXML
                  , Dt_Criacao
                  , Dt_Ultimo_Acesso
                  , Dt_Modificacao
                  , Tamanho)
           VALUES ( @Id_Empresa
                  , Getdate()
                  , @ArquivoXML
                  , @FileNameXML
                  , @pathXML
                  , @Dt_Criacao
                  , @Dt_Ultimo_Acesso
                  , @Dt_Modificacao
                  , @Tamanho)

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES DO ARQUIVO'   
            GOTO TRATA_ERRO   
        END  

        SELECT @Id_Arquivo = SCOPE_IDENTITY()
        
   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_ArquivoXML** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
