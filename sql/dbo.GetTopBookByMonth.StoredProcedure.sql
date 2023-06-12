USE [ComicMaxPrd]
GO
/****** Object:  StoredProcedure [dbo].[GetTopBookByMonth]    Script Date: 6/12/2023 9:02:59 AM ******/
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
    WHERE MONTH(donetime) = @n
    GROUP BY book_id
    ORDER BY SUM(amount) DESC
	)
END
GO
