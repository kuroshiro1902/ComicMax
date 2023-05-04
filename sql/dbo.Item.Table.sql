USE [ComicMax]
GO
/****** Object:  Table [dbo].[Item]    Script Date: 5/3/2023 12:43:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Item](
	[username] [nvarchar](50) NULL,
	[book_id] [int] NULL,
	[amount] [int] NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 1, 4)
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 141, 8)
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 60, 1)
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 55, 7)
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 147, 1)
INSERT [dbo].[Item] ([username], [book_id], [amount]) VALUES (N'admin', 142, 1)
GO
ALTER TABLE [dbo].[Item]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([id])
GO
ALTER TABLE [dbo].[Item]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
