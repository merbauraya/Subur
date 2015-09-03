create table Subur_Author (
	authorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	title nvarchar(75) null,
	idType int,
	remoteId nvarchar(75) null,
	firstName nvarchar(75) null,
	lastName nvarchar(75) null,
	middleName nvarchar(75) null,
	userId int,
	metadata nvarchar(75) null,
	lastPublishedDate datetime null,
	itemCount int,
	createDate datetime null,
	modifiedDate datetime null,
	Uuid nvarchar(75) null,
	createdBy bigint
);

create table Subur_AuthorExpertise (
	authorId bigint not null,
	expertiseId bigint not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId bigint not null primary key,
	authorId bigint,
	siteName nvarchar(75) null,
	siteURL nvarchar(150) null
);

create table Subur_DownloadSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int,
	status int
);

create table Subur_Expertise (
	expertiseId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate datetime null,
	expertiseName nvarchar(75) null,
	indexedName nvarchar(75) null,
	modifiedDate datetime null,
	authorCount int
);

create table Subur_Item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	publishedDate datetime null,
	title nvarchar(255) null,
	itemAbstract nvarchar(max) null,
	language nvarchar(75) null,
	status int,
	Uuid nvarchar(75) null,
	metadataValue nvarchar(max) null
);

create table Subur_ItemAuthor (
	itemId bigint not null,
	authorId bigint not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId bigint not null,
	fileEntryId bigint not null,
	entryType bigint,
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId bigint not null,
	itemTypeId bigint not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	itemTypeId bigint not null primary key,
	itemTypeName nvarchar(75) null,
	itemCount int
);

create table Subur_ItemTypeTemplate (
	itemTypeId bigint not null,
	metadataPropertyId bigint not null,
	required bit,
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId bigint not null primary key,
	metadataSchemaId bigint,
	element nvarchar(255) null,
	scope nvarchar(255) null,
	note nvarchar(1024) null
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue nvarchar(max) null,
	itemCount int
);

create table Subur_MetadataSchema (
	metadataSchemaId bigint not null primary key,
	metadataName nvarchar(1024) null,
	nameSpace nvarchar(75) null
);

create table Subur_StatDownloadCategory (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	categoryId bigint
);

create table Subur_StatDownloadItemType (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	itemTypeId bigint
);

create table Subur_StatDownloadPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int
);

create table Subur_StatDownloadTag (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	tagId bigint
);

create table Subur_StatViewCategory (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	categoryId bigint
);

create table Subur_StatViewItemType (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	itemTypeId bigint
);

create table Subur_StatViewTag (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	tagId bigint
);

create table Subur_ViewSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int,
	status int
);

create table item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title nvarchar(75) null,
	itemAbstract nvarchar(75) null,
	status int
);

create table subur_Author (
	authorId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	title nvarchar(75) null,
	idType int,
	remoteId nvarchar(75) null,
	firstName nvarchar(75) null,
	lastName nvarchar(75) null,
	userId int,
	metadata nvarchar(75) null,
	lastPublishedDate datetime null,
	itemCount int,
	personalSite nvarchar(75) null,
	googleScholar nvarchar(120) null
);

create table subur_AuthorExpertise (
	authorId bigint not null,
	expertiseId bigint not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId bigint not null primary key,
	parentId bigint,
	divisionName nvarchar(75) null,
	depositable bit
);

create table subur_DownloadSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int,
	status int
);

create table subur_Expertise (
	expertiseId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate datetime null,
	expertiseName nvarchar(75) null,
	indexedName nvarchar(75) null,
	modifiedDate datetime null,
	authorCount int
);

create table subur_FileEntryType (
	typeId bigint not null primary key,
	typeName nvarchar(75) null
);

create table subur_Item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	title nvarchar(1024) null,
	itemAbstract nvarchar(2000) null,
	status int
);

create table subur_ItemAuthor (
	itemId bigint not null,
	authorId bigint not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId bigint not null,
	divisionId bigint not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId bigint not null,
	fileEntryId bigint not null,
	entryType bigint,
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId bigint not null,
	itemTypeId bigint not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId bigint not null,
	subjectId bigint not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId bigint not null primary key,
	ItemTypeName nvarchar(75) null,
	itemCount int
);

create table subur_ItemTypeTemplate (
	itemTypeId bigint not null,
	metadataPropertyId bigint not null,
	required bit,
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId bigint not null primary key,
	metadataSchemaId bigint,
	element nvarchar(255) null,
	scope nvarchar(255) null,
	note nvarchar(1024) null
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue nvarchar(max) null,
	itemCount int
);

create table subur_MetadataSchema (
	metadataSchemaId bigint not null primary key,
	metadataName nvarchar(1024) null,
	nameSpace nvarchar(75) null
);

create table subur_MetadataValue (
	metadataValueId bigint not null primary key,
	itemId bigint,
	propertyId bigint,
	textValue nvarchar(75) null
);

create table subur_MetadataValueView (
	propertyId bigint not null,
	subjectId bigint not null,
	subjectName nvarchar(75) null,
	textValue nvarchar(75) null,
	itemCount int,
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	categoryId bigint
);

create table subur_StatDownloadItemType (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	itemTypeId bigint
);

create table subur_StatDownloadPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int
);

create table subur_StatDownloadTag (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	tagId bigint
);

create table subur_StatViewCategory (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	categoryId bigint
);

create table subur_StatViewItemType (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	itemTypeId bigint
);

create table subur_StatViewPeriod (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int
);

create table subur_StatViewTag (
	id_ bigint not null primary key,
	perMonth int,
	perYear int,
	tagId bigint
);

create table subur_Subject (
	subjectId bigint not null primary key,
	parentId bigint,
	subjectName nvarchar(75) null,
	lft int,
	rgt int,
	depositable bit,
	itemCount int
);

create table subur_SubjectTree (
	subjectId bigint not null primary key,
	parentId bigint,
	subjectName nvarchar(75) null,
	lft int,
	rgt int,
	depositable bit,
	itemCount int
);

create table subur_ViewSummary (
	id_ bigint not null primary key,
	itemId bigint,
	perMonth int,
	perYear int,
	status int
);

create table subur_item (
	itemId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	publishedDate datetime null,
	title nvarchar(255) null,
	itemAbstract nvarchar(max) null,
	language nvarchar(75) null,
	status int,
	Uuid nvarchar(75) null,
	metadataValue nvarchar(max) null
);
