/*
  Warnings:

  - A unique constraint covering the columns `[email]` on the table `User` will be added. If there are existing duplicate values, this will fail.

*/
-- AlterTable
ALTER TABLE `batik` MODIFY `name` VARCHAR(255) NOT NULL,
    MODIFY `regional_origin` VARCHAR(255) NOT NULL,
    MODIFY `description` VARCHAR(500) NOT NULL,
    MODIFY `image` VARCHAR(255) NOT NULL;

-- AlterTable
ALTER TABLE `user` MODIFY `name` VARCHAR(255) NOT NULL,
    MODIFY `email` VARCHAR(255) NOT NULL,
    MODIFY `password` VARCHAR(255) NOT NULL;

-- CreateIndex
CREATE UNIQUE INDEX `User_email_key` ON `User`(`email`);
