USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO

IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TSS_Log'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TSS_Log
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir um registro de log
 Parâmetros........: 
 Autor.............: Fernando Souza
 Criação...........: 23/09/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TSS_Log  ( @Nm_Processo VARCHAR (60)  
                                       , @Tp_Log TINYINT  
                                       , @Ds_Log VARCHAR(8000)) 
AS 
BEGIN 

        SET NOCOUNT ON 
        
        DECLARE @COD_ERRO            INT         -- VARIÁVEL COM O RETORNO DE ERRO   
              , @DESC_ERRO           VARCHAR(800)-- VARIÁVEL COM A DESCRICAO DO ERRO   
              , @INT_RET_PROC        INT         -- VARIÁVEL COM O CÓDIGO DE RETORNO DE ERRO DE PROCS  
        
        INSERT INTO dbo.TSS_Log 
                  ( Nm_Processo
                  , Tp_Log 
                  , Ds_Log 
                  , Dt_Inclusao )
           VALUES ( @Nm_Processo
                  , @Tp_Log 
                  , @Ds_Log 
                  , getdate() )

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR um registro de log: ' + @Ds_Log
            GOTO TRATA_ERRO   
        END  

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TSS_Log** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
