USE [ComicMaxPrd]
GO
/****** Object:  Table [dbo].[DeliveryItem]    Script Date: 6/9/2023 1:19:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeliveryItem](
	[username] [nvarchar](100) NOT NULL,
	[book_id] [int] NOT NULL,
	[amount] [int] NULL,
	[payment] [nvarchar](50) NULL,
	[address] [nvarchar](max) NULL,
	[phone] [nvarchar](20) NULL,
	[email] [nvarchar](max) NULL,
	[note] [nvarchar](20) NULL,
	[ordertime] [datetime] NULL,
	[donetime] [datetime] NULL,
	[id] [int] IDENTITY(1,1) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DeliveryItem] ON 

INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 1, 10, N'paypal', N'address', N'0123456789', N'email@gmail.com', N'note123', CAST(N'2023-06-02T02:00:20.930' AS DateTime), NULL, 1)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 1, 10, N'paypal', N'address', N'0123456789', N'email@gmail.com', N'note123', CAST(N'2023-06-02T02:00:20.930' AS DateTime), NULL, 2)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 150, 10, N'paypal', N'address', N'0123456789', N'email@gmail.com', N'note123', CAST(N'2023-05-29T23:20:54.337' AS DateTime), CAST(N'2023-06-09T01:08:24.413' AS DateTime), 3)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 1, 10, N'bank', N'DÂDADAADAD', N'0123456789', N'emailTEST@gmail.com', N'tetststststsst', CAST(N'2023-06-02T02:00:20.930' AS DateTime), NULL, 4)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 1, 10, N'paypal', N'ABC', N'asdasdasd ', N'123123@gmail.com', N'asdsadasdasd ', CAST(N'2023-06-02T02:00:20.930' AS DateTime), CAST(N'2023-06-09T01:01:39.587' AS DateTime), 8)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 1, 3, N'credit', N'ADASDASAD', N'123456798', N'aSDASDADA@gmail.com', N'note', CAST(N'2023-06-01T13:20:11.423' AS DateTime), CAST(N'2023-06-08T22:19:39.437' AS DateTime), 12)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 159, 2, N'cash', N'Hà Nội', N'0123456798', N'emailTEST@gmail.com', N'', CAST(N'2023-06-08T20:56:22.770' AS DateTime), NULL, 13)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 100, 8, N'cash', N'', N'', N'', N'', CAST(N'2023-06-02T01:04:07.247' AS DateTime), NULL, 7)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 105, 8, N'cash', N'uyut', N'rủtutruutr', N'rtuu@j.n', N'rty', CAST(N'2023-06-02T02:06:50.550' AS DateTime), NULL, 9)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 120, 3, N'cash', N'ádad', N'ád', N'asdasdas@gmail.com', N'á', CAST(N'2023-06-02T02:13:33.503' AS DateTime), NULL, 10)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime], [id]) VALUES (N'admin', 100, 3, N'cash', N'r', N'123456798', N'aSDASDADA@gmail.com', N'qưe', CAST(N'2023-06-02T02:34:58.263' AS DateTime), NULL, 11)
SET IDENTITY_INSERT [dbo].[DeliveryItem] OFF
GO
ALTER TABLE [dbo].[DeliveryItem]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[Book] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DeliveryItem]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
