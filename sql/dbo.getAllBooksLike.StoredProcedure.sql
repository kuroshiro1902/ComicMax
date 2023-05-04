USE [ComicMax]
GO
/****** Object:  StoredProcedure [dbo].[getAllBooksLike]    Script Date: 5/3/2023 12:43:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[getAllBooksLike]
    @txt nvarchar(255)
AS
BEGIN
	DECLARE @authorid int
	select @authorid = id
	from Author where Author.name like '%'+@txt+'%'
	DECLARE @Publisherid int
	select @Publisherid = id
	from Publisher where Publisher.name like '%'+@txt+'%'

	SELECT *,1 as [result]
    FROM Book
    WHERE Book.name LIKE '%'+@txt+'%'
    UNION
    SELECT * ,2 as [result]
	from Book 
	where author_id in (
		select id
		from Author
		where name like '%'+@txt+'%'
	) 
	UNION
    SELECT *,3 as [result]
    FROM Book
    WHERE publisher_id in (
		select id
		from Publisher
		where name like '%'+@txt+'%'
	)
	ORDER BY result ASC
END
GO
