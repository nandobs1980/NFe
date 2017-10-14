USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_infNFe_ide'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_infNFe_ide
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de identificação da NF-e
 Parâmetros........: Nenhum 
 Autor.............: Fernando Souza
 Criação...........: 23/09/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_ide ( @Id_Arquivo 	bigint
											, @Id_NFe		VARCHAR(60)
											, @cUF 			smallint
											, @cNF 			decimal(8)
											, @natOp 		varchar(60)
											, @mod 			smallint
											, @serie 		varchar(7)
											, @nNF 			decimal(10)
											, @dhEmi 		datetime
											, @dhSaiEnt 	datetime
											, @tpNF 		smallint
											, @idDest 		smallint
											, @cMunFG 		decimal(7)
											, @tpImp 		smallint
											, @tpEmis 		smallint
											, @cDV 			smallint
											, @tpAmb 		smallint
											, @finNFe 		smallint
											, @indFinal 	smallint
											, @indPres 		smallint
											, @procEmi 		smallint
											, @verProc 		varchar(15)
											, @dhCont 		datetime
											, @xJust 		varchar(256))

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

        INSERT INTO dbo.TNFe_infNFe_ide 
                  ( Id_Empresa 
     			  , Id_Arquivo 
				  , Id_NFe
     			  , cUF 
     			  , cNF 
     			  , natOp 
     			  , mod 
     			  , serie 
     			  , nNF 
     			  , dhEmi 
     			  , dhSaiEnt 
     			  , tpNF 
     			  , idDest 
     			  , cMunFG 
     			  , tpImp 
     			  , tpEmis 
     			  , cDV 
     			  , tpAmb 
     			  , finNFe 
     			  , indFinal 
     			  , indPres 
     			  , procEmi 
     			  , verProc 
     			  , dhCont 
     			  , xJust 
     			  , Dt_inclusao )
           VALUES ( @Id_Empresa
           		  , @Id_Arquivo
				  , @Id_NFe
				  , @cUF 
				  , @cNF 
				  , @natOp 
				  , @mod 
				  , @serie 
				  , @nNF
				  , @dhEmi
				  , @dhSaiEnt
				  , @tpNF 
				  , @idDest
				  , @cMunFG
				  , @tpImp
				  , @tpEmis
				  , @cDV
				  , @tpAmb
				  , @finNFe
				  , @indFinal
				  , @indPres
				  , @procEmi
				  , @verProc
				  , @dhCont
				  , @xJust
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES DA IDENTIFICAÇÃO DA NOTA FISCAL'   
            GOTO TRATA_ERRO   
        END  
           
   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_ide** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC
END    
