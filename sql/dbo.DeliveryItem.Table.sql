USE [ComicMaxPrd]
GO
/****** Object:  Table [dbo].[DeliveryItem]    Script Date: 6/1/2023 7:54:32 AM ******/
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
	[donetime] [datetime] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime]) VALUES (N'admin', 1, 10, N'paypal', N'address', N'0123456789', N'email@gmail.com', N'note123', CAST(N'2023-05-29T23:20:30.950' AS DateTime), NULL)
INSERT [dbo].[DeliveryItem] ([username], [book_id], [amount], [payment], [address], [phone], [email], [note], [ordertime], [donetime]) VALUES (N'admin', 150, 10, N'paypal', N'address', N'0123456789', N'email@gmail.com', N'note123', CAST(N'2023-05-29T23:20:54.337' AS DateTime), NULL)
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
/****** Object:  Trigger [dbo].[tr_DeliveryItem_Insert]    Script Date: 6/1/2023 7:54:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[tr_DeliveryItem_Insert]
ON [dbo].[DeliveryItem]
AFTER INSERT
AS
BEGIN
    UPDATE DeliveryItem
    SET orderTime = GETDATE()
    FROM inserted
    WHERE inserted.username = DeliveryItem.username
        AND inserted.book_id = DeliveryItem.book_id
        AND inserted.amount = DeliveryItem.amount
END;
GO
ALTER TABLE [dbo].[DeliveryItem] ENABLE TRIGGER [tr_DeliveryItem_Insert]
GO
