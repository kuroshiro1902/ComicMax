USE [ComicMax]
GO
/****** Object:  Table [dbo].[DeliveryItem]    Script Date: 5/3/2023 12:43:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeliveryItem](
	[user_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[amount] [int] NULL,
	[payment] [nvarchar](50) NULL,
	[orderTime] [datetime] NULL,
	[doneTime] [datetime] NULL
) ON [PRIMARY]
GO
