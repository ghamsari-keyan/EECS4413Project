delete from item;

INSERT INTO item (itemId, prodType, prodName, prodInfo, brand, quantity, price, rating, ecoFriendly, prodVersion, prodPlatform, weight)
VALUES 
('ITM001', 'Laptop', 'Model X1', '15-inch display, 8GB RAM, 256GB SSD', 'BrandA', 10, 1200.00, 4.5, true, 1.1, 'Windows', 1500),
('ITM002', 'Desktop', 'Model D2', 'Core i5, 16GB RAM, 1TB HDD', 'BrandB', 15, 800.00, 4.3, false, 2.0, 'Linux', 7500),
('ITM003', 'Monitor', 'UltraView 27', '27-inch 4K UHD', 'BrandC', 20, 300.00, 4.7, true, 1.0, 'Any', 3000),
-- Add more items similarly
('ITM004', 'Keyboard', 'Mechanical KB100', 'Mechanical keys, RGB lighting', 'BrandD', 30, 100.00, 4.6, false, 1.2, 'Any', 500),
('ITM005', 'Mouse', 'GamerMouse Pro', 'Ergonomic design, 7 buttons', 'BrandE', 50, 50.00, 4.4, true, 1.3, 'Any', 200),
('ITM006', 'Headphones', 'AudioBeat X', 'Noise cancellation, wireless', 'BrandF', 25, 150.00, 4.8, false, 2.1, 'Any', 300),
('ITM007', 'Speaker', 'SoundWave 3', 'Bluetooth connectivity, waterproof', 'BrandG', 15, 80.00, 4.2, true, 2.0, 'Any', 600),
('ITM008', 'Tablet', 'Tab Elite 8', '8-inch screen, 64GB storage', 'BrandH', 10, 400.00, 4.5, false, 1.4, 'Android', 700),
('ITM009', 'Router', 'NetFast X500', 'Dual-band, 4 antennas', 'BrandI', 20, 120.00, 4.3, true, 1.5, 'Any', 400),
('ITM010', 'Printer', 'PrintMaster 2000', 'Laser printer, wireless', 'BrandJ', 12, 250.00, 4.0, false, 1.0, 'Any', 5000),
('ITM011', 'Scanner', 'ScanPro 3D', '3D scanning capabilities', 'BrandK', 5, 500.00, 4.6, true, 1.2, 'Any', 4500),
('ITM012', 'Webcam', 'ClearView HD', '1080p, built-in microphone', 'BrandL', 25, 70.00, 4.4, false, 1.0, 'Any', 150),
('ITM013', 'External Drive', '1TB StorePlus', '1TB capacity, USB 3.0', 'BrandM', 20, 90.00, 4.7, true, 1.1, 'Any', 250),
('ITM014', 'Graphics Card', 'GTX 1080Ti', '11GB GDDR5X', 'BrandN', 8, 700.00, 4.8, false, 1.0, 'Any', 800),
('ITM015', 'RAM', '16GB DDR4', '16GB, 3200MHz', 'BrandO', 30, 60.00, 4.5, true, 1.0, 'Any', 100);
