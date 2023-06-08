USE [ComicMaxPrd]
GO
/****** Object:  StoredProcedure [dbo].[GetTopBookByMonth]    Script Date: 6/9/2023 1:19:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[GetTopBookByMonth]
    @n INT
AS
BEGIN
select * from book where id in
(
    SELECT TOP 1 book_id
    FROM DeliveryItem
    WHERE MONTH(ordertime) = @n
    GROUP BY book_id
    ORDER BY SUM(amount) DESC
	)
END
GO
