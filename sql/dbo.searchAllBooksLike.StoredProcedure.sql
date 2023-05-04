USE [ComicMax]
GO
/****** Object:  StoredProcedure [dbo].[searchAllBooksLike]    Script Date: 5/3/2023 12:43:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[searchAllBooksLike]
	@txt nvarchar (255)
as
begin
	declare @results table (id int, Name nvarchar(255), Img nvarchar(max), Language nvarchar(50), Author_id int, Publisher_id int , Price float, Amount int , Sold int, Star float, Ratingnums int, result int)

	CREATE TABLE #TokenList (Token nvarchar(255))
	INSERT INTO #TokenList (Token)
	SELECT value FROM string_split(@txt, ' ')
	DECLARE @token nvarchar(255)
DECLARE @cursor CURSOR

SET @cursor = CURSOR FOR SELECT Token FROM #TokenList

OPEN @cursor
FETCH NEXT FROM @cursor INTO @token

WHILE @@FETCH_STATUS = 0
BEGIN
	insert into @results
    EXEC getAllBooksLike @token
    FETCH NEXT FROM @cursor INTO @token
END

CLOSE @cursor
DEALLOCATE @cursor
DROP TABLE #TokenList
select * from @results
end
GO
