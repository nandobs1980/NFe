USE [nfe] 
GO
SET ANSI_NULLS ON 
GO
SET QUOTED_IDENTIFIER ON 
GO
IF EXISTS(SELECT 1 FROM SYSOBJECTS WHERE ID = OBJECT_ID('SPnfe_IN_TNFe_infNFe_det_imposto_ISSQN'))
BEGIN
    DROP PROCEDURE SPnfe_IN_TNFe_infNFe_det_imposto_ISSQN
END
GO
/********************************************************************************************************************** 
 Objetivo..........: Inserir dados da NFe referente ao bloco de ISSQN
 Parâmetros........: Nenhum
 Autor.............: Fernando Souza
 Criação...........: 13/10/2017 
 Versão............: {01.00} 
 ----------------------------------------------------------------------------------------------------------------------            
 Alteração......... :
 Responsável....... :          
 Motivo............ :   
 **********************************************************************************************************************/ 
CREATE PROCEDURE dbo.SPnfe_IN_TNFe_infNFe_det_imposto_ISSQN ( @Id_Arquivo   BIGINT 
                                                            , @nItem         INTEGER
                                                            , @vBC          DECIMAL (15,2)  
                                                            , @vAliq        DECIMAL (7,4) 
                                                            , @vISSQN       DECIMAL (15,2)  
                                                            , @cMunFG       DECIMAL (7)  
                                                            , @cListServ    DECIMAL (4,2)  
                                                            , @vDeducao     DECIMAL (15,2)  
                                                            , @vOutro       DECIMAL (15,2)  
                                                            , @vDescIncond  DECIMAL (15,2)  
                                                            , @vDescCond    DECIMAL (15,2)  
                                                            , @vISSRet      DECIMAL (15,2)  
                                                            , @indISS       TINYINT  
                                                            , @cServico     VARCHAR (20)  
                                                            , @cMun         DECIMAL (7)  
                                                            , @cPais        DECIMAL (4)  
                                                            , @nProcesso    VARCHAR (30)  
                                                            , @indIncentivo TINYINT )

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

        INSERT INTO dbo.TNFe_infNFe_det_imposto_ISSQN 
                  ( Id_Arquivo
                  , Id_Empresa
                  , nItem
                  , vBC       
                  , vAliq     
                  , vISSQN    
                  , cMunFG    
                  , cListServ 
                  , vDeducao  
                  , vOutro    
                  , vDescIncond 
                  , vDescCond   
                  , vISSRet     
                  , indISS      
                  , cServico    
                  , cMun        
                  , cPais       
                  , nProcesso   
                  , indIncentivo
                  , Dt_Inclusao)
           VALUES ( @Id_Arquivo
                  , @Id_Empresa
                  , @nItem
                  , @vBC       
                  , @vAliq     
                  , @vISSQN    
                  , @cMunFG    
                  , @cListServ 
                  , @vDeducao  
                  , @vOutro    
                  , @vDescIncond 
                  , @vDescCond   
                  , @vISSRet     
                  , @indISS      
                  , @cServico    
                  , @cMun        
                  , @cPais       
                  , @nProcesso   
                  , @indIncentivo 
                  , getdate())

        SET @COD_ERRO = @@ERROR   
        IF @COD_ERRO != 0 BEGIN   
            SET @DESC_ERRO = 'ERRO AO INSERIR AS INFORMACOES da NFe referente a ISSQN'   
            GOTO TRATA_ERRO   
        END

   RETURN       
      
TRATA_ERRO:       

   SET @DESC_ERRO = '**SPnfe_IN_TNFe_infNFe_det_imposto_ISSQN** - ' + @DESC_ERRO       
   RAISERROR (@DESC_ERRO,16,1)       
   RETURN @COD_ERRO + @INT_RET_PROC       
END    
