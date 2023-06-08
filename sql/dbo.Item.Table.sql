USE [ComicMaxPrd]
GO
/****** Object:  Table [dbo].[Item]    Script Date: 6/9/2023 1:19:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Item](
	[username] [nvarchar](100) NULL,
	[book_id] [int] NULL,
	[amount] [int] NULL,
	[Itemid] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Itemid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Item] ON 

INSERT [dbo].[Item] ([username], [book_id], [amount], [Itemid]) VALUES (N'client', 97, 11, 7)
INSERT [dbo].[Item] ([username], [book_id], [amount], [Itemid]) VALUES (N'admin', 149, 2, 15)
SET IDENTITY_INSERT [dbo].[Item] OFF
GO
ALTER TABLE [dbo].[Item]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Item]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
