USE [ComicMaxPrd]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/9/2023 1:19:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[fullname] [nvarchar](255) NULL,
	[username] [nvarchar](100) NOT NULL,
	[password] [nvarchar](max) NULL,
	[avatar] [nvarchar](max) NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Account] ([fullname], [username], [password], [avatar], [isAdmin]) VALUES (N'Administrator', N'admin', N'0109702100031090410505110', NULL, 1)
INSERT [dbo].[Account] ([fullname], [username], [password], [avatar], [isAdmin]) VALUES (N'Bui Thanh Son', N'client', N'010990210803105041010511006116', NULL, 0)
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ((0)) FOR [isAdmin]
GO
