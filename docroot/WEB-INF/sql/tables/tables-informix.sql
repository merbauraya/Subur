create table Subur_Author (
	authorId int8 not null primary key,
	groupId int8,
	companyId int8,
	title varchar(75),
	idType int,
	remoteId varchar(75),
	firstName varchar(75),
	lastName varchar(75),
	middleName varchar(75),
	userId int,
	metadata varchar(75),
	lastPublishedDate datetime YEAR TO FRACTION,
	itemCount int,
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	Uuid varchar(75),
	createdBy int8
)
extent size 16 next size 16
lock mode row;

create table Subur_AuthorExpertise (
	authorId int8 not null,
	expertiseId int8 not null,
	primary key (authorId, expertiseId)
)
extent size 16 next size 16
lock mode row;

create table Subur_AuthorSite (
	authorSiteId int8 not null primary key,
	authorId int8,
	siteName varchar(75),
	siteURL varchar(150)
)
extent size 16 next size 16
lock mode row;

create table Subur_DownloadSummary (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int,
	status int
)
extent size 16 next size 16
lock mode row;

create table Subur_Expertise (
	expertiseId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	createDate datetime YEAR TO FRACTION,
	expertiseName varchar(75),
	indexedName varchar(75),
	modifiedDate datetime YEAR TO FRACTION,
	authorCount int
)
extent size 16 next size 16
lock mode row;

create table Subur_Item (
	itemId int8 not null primary key,
	companyId int8,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	publishedDate datetime YEAR TO FRACTION,
	title varchar(255),
	itemAbstract text,
	language varchar(75),
	status int,
	Uuid varchar(75),
	metadataValue text
)
extent size 16 next size 16
lock mode row;

create table Subur_ItemAuthor (
	itemId int8 not null,
	authorId int8 not null,
	primary key (itemId, authorId)
)
extent size 16 next size 16
lock mode row;

create table Subur_ItemFileEntry (
	itemId int8 not null,
	fileEntryId int8 not null,
	entryType int8,
	primary key (itemId, fileEntryId)
)
extent size 16 next size 16
lock mode row;

create table Subur_ItemItemType (
	itemId int8 not null,
	itemTypeId int8 not null,
	primary key (itemId, itemTypeId)
)
extent size 16 next size 16
lock mode row;

create table Subur_ItemType (
	itemTypeId int8 not null primary key,
	itemTypeName varchar(75),
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table Subur_ItemTypeTemplate (
	itemTypeId int8 not null,
	metadataPropertyId int8 not null,
	required boolean,
	primary key (itemTypeId, metadataPropertyId)
)
extent size 16 next size 16
lock mode row;

create table Subur_MetadataProperty (
	metadataPropertyId int8 not null primary key,
	metadataSchemaId int8,
	element varchar(255),
	scope varchar(255),
	note lvarchar(1024)
)
extent size 16 next size 16
lock mode row;

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId int8 not null primary key,
	itemId int8,
	propertyId int8,
	textValue text,
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table Subur_MetadataSchema (
	metadataSchemaId int8 not null primary key,
	metadataName lvarchar(1024),
	nameSpace varchar(75)
)
extent size 16 next size 16
lock mode row;

create table Subur_StatDownloadCategory (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	categoryId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_StatDownloadItemType (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	itemTypeId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_StatDownloadPeriod (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int
)
extent size 16 next size 16
lock mode row;

create table Subur_StatDownloadTag (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	tagId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_StatViewCategory (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	categoryId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_StatViewItemType (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	itemTypeId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_StatViewTag (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	tagId int8
)
extent size 16 next size 16
lock mode row;

create table Subur_ViewSummary (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int,
	status int
)
extent size 16 next size 16
lock mode row;

create table item (
	itemId int8 not null primary key,
	companyId int8,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	title varchar(75),
	itemAbstract varchar(75),
	status int
)
extent size 16 next size 16
lock mode row;

create table subur_Author (
	authorId int8 not null primary key,
	groupId int8,
	companyId int8,
	title varchar(75),
	idType int,
	remoteId varchar(75),
	firstName varchar(75),
	lastName varchar(75),
	userId int,
	metadata varchar(75),
	lastPublishedDate datetime YEAR TO FRACTION,
	itemCount int,
	personalSite varchar(75),
	googleScholar varchar(120)
)
extent size 16 next size 16
lock mode row;

create table subur_AuthorExpertise (
	authorId int8 not null,
	expertiseId int8 not null,
	primary key (authorId, expertiseId)
)
extent size 16 next size 16
lock mode row;

create table subur_Division (
	divisionId int8 not null primary key,
	parentId int8,
	divisionName varchar(75),
	depositable boolean
)
extent size 16 next size 16
lock mode row;

create table subur_DownloadSummary (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int,
	status int
)
extent size 16 next size 16
lock mode row;

create table subur_Expertise (
	expertiseId int8 not null primary key,
	groupId int8,
	companyId int8,
	userId int8,
	createDate datetime YEAR TO FRACTION,
	expertiseName varchar(75),
	indexedName varchar(75),
	modifiedDate datetime YEAR TO FRACTION,
	authorCount int
)
extent size 16 next size 16
lock mode row;

create table subur_FileEntryType (
	typeId int8 not null primary key,
	typeName varchar(75)
)
extent size 16 next size 16
lock mode row;

create table subur_Item (
	itemId int8 not null primary key,
	companyId int8,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	title lvarchar(1024),
	itemAbstract lvarchar,
	status int
)
extent size 16 next size 16
lock mode row;

create table subur_ItemAuthor (
	itemId int8 not null,
	authorId int8 not null,
	primary key (itemId, authorId)
)
extent size 16 next size 16
lock mode row;

create table subur_ItemDivision (
	itemId int8 not null,
	divisionId int8 not null,
	primary key (itemId, divisionId)
)
extent size 16 next size 16
lock mode row;

create table subur_ItemFileEntry (
	itemId int8 not null,
	fileEntryId int8 not null,
	entryType int8,
	primary key (itemId, fileEntryId)
)
extent size 16 next size 16
lock mode row;

create table subur_ItemItemType (
	itemId int8 not null,
	itemTypeId int8 not null,
	primary key (itemId, itemTypeId)
)
extent size 16 next size 16
lock mode row;

create table subur_ItemSubject (
	itemId int8 not null,
	subjectId int8 not null,
	primary key (itemId, subjectId)
)
extent size 16 next size 16
lock mode row;

create table subur_ItemType (
	ItemTypeId int8 not null primary key,
	ItemTypeName varchar(75),
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table subur_ItemTypeTemplate (
	itemTypeId int8 not null,
	metadataPropertyId int8 not null,
	required boolean,
	primary key (itemTypeId, metadataPropertyId)
)
extent size 16 next size 16
lock mode row;

create table subur_MetadataProperty (
	metadataPropertyId int8 not null primary key,
	metadataSchemaId int8,
	element varchar(255),
	scope varchar(255),
	note lvarchar(1024)
)
extent size 16 next size 16
lock mode row;

create table subur_MetadataPropertyValue (
	metadataPropertyValueId int8 not null primary key,
	itemId int8,
	propertyId int8,
	textValue text,
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table subur_MetadataSchema (
	metadataSchemaId int8 not null primary key,
	metadataName lvarchar(1024),
	nameSpace varchar(75)
)
extent size 16 next size 16
lock mode row;

create table subur_MetadataValue (
	metadataValueId int8 not null primary key,
	itemId int8,
	propertyId int8,
	textValue varchar(75)
)
extent size 16 next size 16
lock mode row;

create table subur_MetadataValueView (
	propertyId int8 not null,
	subjectId int8 not null,
	subjectName varchar(75),
	textValue varchar(75),
	itemCount int,
	primary key (propertyId, subjectId)
)
extent size 16 next size 16
lock mode row;

create table subur_StatDownloadCategory (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	categoryId int8
)
extent size 16 next size 16
lock mode row;

create table subur_StatDownloadItemType (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	itemTypeId int8
)
extent size 16 next size 16
lock mode row;

create table subur_StatDownloadPeriod (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int
)
extent size 16 next size 16
lock mode row;

create table subur_StatDownloadTag (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	tagId int8
)
extent size 16 next size 16
lock mode row;

create table subur_StatViewCategory (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	categoryId int8
)
extent size 16 next size 16
lock mode row;

create table subur_StatViewItemType (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	itemTypeId int8
)
extent size 16 next size 16
lock mode row;

create table subur_StatViewPeriod (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int
)
extent size 16 next size 16
lock mode row;

create table subur_StatViewTag (
	id_ int8 not null primary key,
	perMonth int,
	perYear int,
	tagId int8
)
extent size 16 next size 16
lock mode row;

create table subur_Subject (
	subjectId int8 not null primary key,
	parentId int8,
	subjectName varchar(75),
	lft int,
	rgt int,
	depositable boolean,
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table subur_SubjectTree (
	subjectId int8 not null primary key,
	parentId int8,
	subjectName varchar(75),
	lft int,
	rgt int,
	depositable boolean,
	itemCount int
)
extent size 16 next size 16
lock mode row;

create table subur_ViewSummary (
	id_ int8 not null primary key,
	itemId int8,
	perMonth int,
	perYear int,
	status int
)
extent size 16 next size 16
lock mode row;

create table subur_item (
	itemId int8 not null primary key,
	companyId int8,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	publishedDate datetime YEAR TO FRACTION,
	title varchar(255),
	itemAbstract text,
	language varchar(75),
	status int,
	Uuid varchar(75),
	metadataValue text
)
extent size 16 next size 16
lock mode row;
