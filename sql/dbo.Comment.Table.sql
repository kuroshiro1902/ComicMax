USE [ComicMaxPrd]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 6/9/2023 1:19:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[username] [nvarchar](100) NULL,
	[book_id] [int] NULL,
	[content] [nvarchar](max) NULL,
	[posttime] [datetime] NULL,
	[id] [int] IDENTITY(1,1) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Comment] ON 

INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 97, N'modify', CAST(N'2023-06-01T22:49:01.683' AS DateTime), 9)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 1, N'son dep chai', CAST(N'2023-06-01T23:12:07.140' AS DateTime), 12)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'client', 97, N'lijlkjljkjlkjl', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 2)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 118, N'Test Responsive', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 3)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 97, N'Test trigger', CAST(N'2023-06-01T22:49:01.683' AS DateTime), 10)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 120, N'test comment', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 5)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'client', 87, N'Sơn đẹp trai', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[Comment] ([username], [book_id], [content], [posttime], [id]) VALUES (N'admin', 100, N'Admintest', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 8)
SET IDENTITY_INSERT [dbo].[Comment] OFF
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
