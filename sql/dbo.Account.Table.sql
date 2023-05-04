USE [ComicMax]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 5/3/2023 12:43:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[fullname] [nvarchar](100) NULL,
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[avatar] [nvarchar](255) NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([fullname], [username], [password], [avatar], [isAdmin]) VALUES (N'Administrator', N'admin', N'admin', N'./img/default.webp', 1)
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((0)) FOR [isAdmin]
GO
